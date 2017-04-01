CREATE OR REPLACE FUNCTION unique_user_role()
  RETURNS TRIGGER AS $unique_user_role$
BEGIN
  IF (tg_table_name = 'student')
  THEN
    IF (NEW.User_ID IN (
      SELECT User_ID
      FROM Moderator)) OR (NEW.User_ID IN (
      SELECT User_ID
      FROM Admin))
    THEN
      RAISE EXCEPTION 'This user is already a moderator or admin';
    END IF;
  ELSIF (tg_table_name = 'moderator')
    THEN
      IF (NEW.User_ID IN (
        SELECT User_ID
        FROM Student)) OR (NEW.User_ID IN (
        SELECT User_ID
        FROM Admin))
      THEN
        RAISE EXCEPTION 'This user is already a student or admin';
      END IF;
  ELSIF (tg_table_name = 'admin')
    THEN
      IF (NEW.User_ID IN (
        SELECT User_ID
        FROM Moderator)) OR (NEW.User_ID IN (
        SELECT User_ID
        FROM Student))
      THEN
        RAISE EXCEPTION 'This user is already a student or moderator';
      END IF;
  END IF;
  RETURN NEW;
END;
$unique_user_role$ LANGUAGE plpgsql;

CREATE TRIGGER unique_user_role
BEFORE INSERT OR UPDATE ON Student
FOR EACH ROW EXECUTE PROCEDURE unique_user_role();

CREATE TRIGGER unique_user_role
BEFORE INSERT OR UPDATE ON Moderator
FOR EACH ROW EXECUTE PROCEDURE unique_user_role();

CREATE TRIGGER unique_user_role
BEFORE INSERT OR UPDATE ON Admin
FOR EACH ROW EXECUTE PROCEDURE unique_user_role();


CREATE OR REPLACE FUNCTION increase_num_Emp()
  RETURNS TRIGGER AS
$$
BEGIN
  UPDATE Company
  SET number_of_employees = number_of_employees + 1
  FROM Jobs
  WHERE Jobs.Job_ID = new.Job_ID AND Jobs.company_name = company.company_name;
  RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER increment_of_emp
AFTER INSERT ON Does
FOR EACH ROW
EXECUTE PROCEDURE increase_num_Emp();


CREATE OR REPLACE FUNCTION reduce_job_positions()
  RETURNS TRIGGER AS
$$
BEGIN
  UPDATE Jobs
  SET Number_Of_Positions = Number_Of_Positions - 1
  WHERE Jobs.Job_ID = new.Job_ID;
  RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER student_hired
AFTER INSERT ON Does
FOR EACH ROW
EXECUTE PROCEDURE reduce_job_positions();


CREATE OR REPLACE FUNCTION check_position_avaliable()
  RETURNS TRIGGER AS
$$
BEGIN
  IF (SELECT Number_Of_Positions
      FROM Jobs
      WHERE Jobs.Job_ID = new.Job_ID) = 0
  THEN
    RAISE EXCEPTION 'The position is not avaliable any more';
  END IF;
  RETURN NEW;
END
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER position_valid_check
BEFORE INSERT ON Does
FOR EACH ROW
EXECUTE PROCEDURE check_position_avaliable();


CREATE OR REPLACE FUNCTION count_update()
  RETURNS TRIGGER AS
$$
BEGIN
  UPDATE Review
  SET Vote_count = Vote_count + 1
  WHERE Review.Review_ID = new.Review_ID;
  RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER update_vote
AFTER INSERT ON Upvote
FOR EACH ROW
EXECUTE PROCEDURE count_update();

CREATE OR REPLACE FUNCTION deletePendingJob()
  RETURNS TRIGGER AS
$$
BEGIN
  DELETE FROM JobPending
  WHERE JobPending.Job_ID = new.Job_ID;
  RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER update_jobPending
AFTER INSERT ON Jobs
FOR EACH ROW
EXECUTE PROCEDURE deletePendingJob();

CREATE OR REPLACE FUNCTION added_resume_review()
  RETURNS TRIGGER AS
$$
BEGIN
  DELETE FROM resumereviewrequest
  WHERE user_id = new.user_id AND version_number = new.version_number;
  RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

CREATE TRIGGER added_resume_review
AFTER INSERT ON resumereview
FOR EACH ROW
EXECUTE PROCEDURE added_resume_review();

