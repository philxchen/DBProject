CREATE TABLE Users (
  User_ID  SERIAL,
  Email    VARCHAR(89) UNIQUE,
  Fname    VARCHAR(20) NOT NULL,
  Lname    VARCHAR(20) NOT NULL,
  Password VARCHAR(20) NOT NULL,
  PRIMARY KEY (User_ID)
);

CREATE TABLE Program (
  Program_Name VARCHAR(20),
  Field        VARCHAR(20),
  PRIMARY KEY (Program_Name)
);

CREATE TABLE Student (
  User_ID       INTEGER,
  Program       VARCHAR(20),
  Student_Level INTEGER NOT NULL,
  PRIMARY KEY (User_ID),
  FOREIGN KEY (User_ID) REFERENCES Users
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (Program) REFERENCES Program (Program_Name)
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE Admin (
  User_ID  INTEGER,
  Admin_ID SERIAL UNIQUE,
  PRIMARY KEY (User_ID),
  FOREIGN KEY (User_ID) REFERENCES Users
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE Moderator (
  User_ID      INTEGER,
  Moderator_ID SERIAL UNIQUE,
  PRIMARY KEY (User_ID),
  FOREIGN KEY (User_ID) REFERENCES Users
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE Company (
  Company_Name        VARCHAR(20),
  Number_Of_Employees INTEGER,
  Location            VARCHAR(100),
  Website             VARCHAR(30),
  PRIMARY KEY (Company_name)
);

CREATE TABLE Jobs (
  Job_ID              INTEGER,
  Company_Name        VARCHAR(20) NOT NULL,
  Title               VARCHAR(30),
  Description         TEXT,
  Student_Level       INTEGER,
  Number_Of_Positions INTEGER,
  Salary              INTEGER,
  Start_date          DATE,
  End_date            DATE,
  PRIMARY KEY (Job_ID),
  FOREIGN KEY (Company_Name) REFERENCES Company
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT Student_level_check CHECK (Student_Level >= 1 AND Student_Level <= 6),
  CONSTRAINT Number_of_positions CHECK (Number_Of_Positions >= 0),
  CONSTRAINT Salary_check CHECK (Salary >= 0)
);

CREATE TABLE Resume (
  User_ID         INTEGER,
  Version_number  INTEGER,
  Education       TEXT,
  Skill           TEXT,
  Work_experience TEXT,
  PRIMARY KEY (User_ID, Version_number),
  FOREIGN KEY (User_ID) REFERENCES Student (User_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT Version_number_check CHECK (Version_number >= 1)
);

CREATE TABLE ResumeReviewRequest (
  User_ID        INTEGER,
  Version_number INTEGER,
  PRIMARY KEY (User_ID, Version_number),
  FOREIGN KEY (User_ID, Version_number) REFERENCES Resume
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE ResumeReview (
  Moderator_ID   INTEGER,
  User_ID        INTEGER,
  Version_Number INTEGER,
  Comment        TEXT NOT NULL,
  PRIMARY KEY (Moderator_ID, User_ID, Version_Number),
  FOREIGN KEY (Moderator_ID) REFERENCES Moderator (Moderator_ID)
  ON DELETE RESTRICT
  ON UPDATE CASCADE,
  FOREIGN KEY (User_ID, Version_Number) REFERENCES Resume
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE Review (
  User_ID      INTEGER,
  Review_ID    SERIAL,
  Company_Name VARCHAR(30),
  Date         DATE,
  Title        VARCHAR(30),
  Body         TEXT,
  Vote_count   INTEGER DEFAULT 0,
  PRIMARY KEY (Review_ID),
  FOREIGN KEY (User_ID) REFERENCES Student (User_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (Company_Name) REFERENCES Company
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

-- Table for relationship
CREATE TABLE Apply (
  User_ID INTEGER,
  Job_ID  INTEGER,
  PRIMARY KEY (User_ID, Job_ID),
  FOREIGN KEY (User_ID) REFERENCES Student (User_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (Job_ID) REFERENCES Jobs
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE Approve (
  Admin_ID INTEGER,
  Job_ID   INTEGER,
  PRIMARY KEY (Admin_ID, Job_ID),
  FOREIGN KEY (Admin_ID) REFERENCES Admin (Admin_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (Job_ID) REFERENCES Jobs
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE Job_for_program (
  Program_Name VARCHAR(20),
  Job_ID       INTEGER,
  PRIMARY KEY (Program_name, Job_ID),
  FOREIGN KEY (Program_name) REFERENCES Program
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (Job_ID) REFERENCES Jobs
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE Upvote (
  User_ID   INTEGER,
  Review_ID INTEGER,
  PRIMARY KEY (User_ID, Review_ID),
  FOREIGN KEY (User_ID) REFERENCES Users
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (Review_ID) REFERENCES Review
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE Rate_Company (
  User_ID      INTEGER,
  Company_name VARCHAR(30),
  Mark         INTEGER,
  PRIMARY KEY (User_ID, Company_name),
  FOREIGN KEY (User_ID) REFERENCES Users
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (Company_name) REFERENCES Company
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT mark_check CHECK (mark >= 0 AND mark <= 5)
);

CREATE TABLE Does (
  User_ID INTEGER,
  Job_ID  INTEGER,
  PRIMARY KEY (User_ID, Job_ID),
  FOREIGN KEY (User_ID) REFERENCES Student (User_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  FOREIGN KEY (Job_ID) REFERENCES Jobs
  ON DELETE CASCADE
  ON UPDATE CASCADE
);

CREATE TABLE jobPending(
  Job_ID              SERIAL,
  Company_Name        VARCHAR(20) NOT NULL,
  Title               VARCHAR(30),
  Description         TEXT,
  Student_Level       INTEGER,
  Number_Of_Positions INTEGER,
  Salary              INTEGER,
  Start_date          DATE,
  End_date            DATE,
  PRIMARY KEY (Job_ID),
  FOREIGN KEY (Company_Name) REFERENCES Company
  ON DELETE CASCADE
  ON UPDATE CASCADE,
  CONSTRAINT Student_level_check CHECK (Student_Level >= 1 AND Student_Level <= 6),
  CONSTRAINT Number_of_positions CHECK (Number_Of_Positions >= 0),
  CONSTRAINT Salary_check CHECK (Salary >= 0)
);