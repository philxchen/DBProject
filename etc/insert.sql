﻿INSERT INTO Users Values
	(default, 'Jinyang@uottawa.ca', 'Jinyang', 'Huang', 'aaa'),
	(default, 'Xuankai@uottawa.ca', 'Xuankai', 'Chen', 'bbb'),
	(default, 'Likai@uottawa.ca', 'Likai', 'Wang', 'ccc'),
	(default, 'Tyler@uottawa.ca', 'Tyler', 'Wilson', 'ddd'),
	(default,'Mark@uottawa.ca','Mark','Jason','database'),
	(default,'Lenoard@uottawa.ca','Leonard','Knox','lose'),
	(default,'Milo@algonquin.ca','Milo','Masson','erdigram'),
	(default,'Nigel@algonquin.ca','Nigel','Nevin','nopassword'),
	(default,'Adele@algonquin.ca','Adele','Bessemer','whoareyou'),
	(default,'Belinda@gmail.ca','Belinda','Raman','eee'),
	(default,'Keanu@gamil.ca','keanu','Reeves','youguess'),
	(default,'John@cartoon.ca','John','Barrowman','nomark'),
	(default,'Jean@cartoon.ca','Jeam','Mraz','pop'),
	(default,'Lily@cartoon.ca','Lily','Allem','noidea'),
	(default,'Anmir@outlook.ca','Anmir','Kham','fff'),
	(default,'Ianto@outlook.ca','Ianto','Jones','apple'),
	(default,'Susan@outlook.ca','Susan','Bayle','pen'),
	(default,'Sara@waterloo.ca','Sara','Bareilles','ggg'),
	(default,'Nicolas@waterloo.ca','Nicolas','Cage','finish'),
	(default,'Jean@waterloo.ca','jean','Mraz','fillmark'),
	(default,'Ahern@gamil.ca','Ahern','Ralap','nonumber'),
	(default,'Albert@gamil.ca','Albert','Reg','superkey'),
	(default,'Barry@gamil.ca','Barry','Tab','lowerkey'),
	(default,'Baron@gamil.ca','Baron','Thomas','slarge'),
	(default,'Corey@gamil.ca','Corey','Quinn','wodwod'),
	(default,'Cyril@gamil.ca','Cyril','Relap','zhzazha'),
	(default,'Carig@gamil.ca','Carig','Dean','sdbsdbus'),
	(default,'Duke@gamil.ca','Duke','David','sdhsd'),
	(default,'Dunn@gamil.ca','Dunn','Colbert','dhfhdfh'),
	(default,'Ron@gamil.ca','Ron','Colby','dbdfu'),
	(default,'Roty@gamil.ca','Roty','Carr','dfndif'),
	(default,'Tyler@gamil.ca','Tyler','Eric','weeihw'),
	(default,'Truman@gamil.ca','Truman','Eanest','oqowe'),
	(default,'Walker@gamil.ca','Walker','Elory','reset'),
	(default,'Wendell@gamil.ca','Wendell','Robin','resert'),
	(default,'York@gamil.ca','York','Rex','begin'),
	(default,'Ziv@gamil.ca','Ziv','Brook','jump'),
	(default,'Evan@gamil.ca','Evan','Camile','laptop'),
	(default,'Felix@gamil.ca','Felix','Brifgt','note'),
	(default,'Rachel@gamil.ca','Rachel','Candance','end');
     

INSERT INTO Program VALUES
	('CSI','Engineering'),
	('BIO','Science'),
	('SEG','Engineering'),
	('MAT','Science'),
	('PHI','Art'),
	('PSY','Art'),
	('PHY','Engineering'),
	('CEG','Engineering'),
	('PED','Education'),
	('ANP','HealthScience'),
	('HSS','HealthScience'),
	('GNG','Engineering'),
	('MCG','Engineering');
	

	
INSERT INTO Student VALUES
	(1,'CSI', 3),
	(2,'CSI', 3),
	(3,'MAT',4),
	(4,'PSY',4),
	(5,'PED',1),
	(6,'HSS',5),
	(7,'ANP',3),
	(8,'CSI',3),
	(9,'MCG',6),
	(10,'GNG',5),
	(11,'PHI',4),
	(12,'SEG',4),
	(13,'MCG',5),
	(14,'MAT',4),
	(15,'ANP',6),
	(16,'CEG',4),
	(17,'PED',4),
	(18,'PHY',3),
	(19,'GNG',3),
	(20,'HSS',4);
	

INSERT INTO Admin VALUES
	(21,default),
	(22,default),
	(23,default),
	(24,default),
	(25,default),
	(26,default),
	(27,default),
	(28,default),
	(29,default),
	(30,default);
	

INSERT INTO Moderator VALUES
	(31,default),
	(32,default),
	(33,default),
	(34,default),
	(35,default),
	(36,default),
	(37,default),
	(38,default),
	(39,default),
	(40,default);

INSERT INTO Company VALUES
	('Red 1 Engineering', 50, 'Ottawa', 'Red1.ca'),
	('Blue 2 Science', 210, 'Toronto', 'Blue2.ca'),
	('Fido',300,'Ottawa','fido.ca'),
	('Rogers',400,'Waterloo','Rodwes.ca,'),
	('IBM',151,'Ottawa','IBM.ca'),
	('Ebay',316,'Tornoto','Ebay.ca'),
	('Google',135,'Vancouver','Google.ca'),
	('Pepsi',834,'Montreal','Pepsi.ca'),
	('Playboy',230,'Montreal','Playbot.ca'),
	('Yahoo',450,'Victoria','Yahoo.ca'),
	('BestBuy',234,'Halifax','BestBuy.ca'),
	('Apple',234,'Quebec City','Apple.ca'),
	('Hertz',78,'Calgary','Hertz.ca'),
	('Subway',245,'Waterloo','Subway.ca'),
	('Nintend',345,'Halifax','Nintend.ca');
	
INSERT INTO jobPending VALUES
	(default, 'Red 1 Engineering', 'Mechanical designer', 'blabla', 3, 20, 500, '04-03-2018', '04-05-2018'),
	(default, 'Red 1 Engineering', 'Test engineer', 'clacla', 2, 10, 250, '04-03-2018', '04-05-2018'),
	(default, 'Blue 2 Science', 'Electrician', 'deladela', 4, 10, 700, '04-03-2018', '04-04-2018'),
	(default,'Subway','Seller','blabla',3,10,1000,'10-06-2018','11-06-2018'),
	(default,'Hertz','Manager','clacla',2,50,2000,'10-06-2018','11-06-2018'),
	(default,'Apple','Experience staf','deladela',1,100,300,'01-01-2018','05-01-2018'),
	(default,'Apple','Manager','lalala',5,10,1500,'07-07-2018','07-09-2018'),
	(default,'Yahoo','Mechanical designer','deladela',4,10,1000,'01-04-2018','05-02-2018'),
	(default,'Playboy','Clothes designer','deladela',3,10,2000,'07-07-2018','09-07-2018'),
	(default,'IBM','Test engineer','deladela',4,20,1500,'02-01-2018','03-03-2018'),
	(default,'Pepsi','Seller','deladela',4,20,2000,'05-08-2018','06-09-2018'),
	(default,'BestBuy','HR','deladela',1,40,3000,'03-09-2018','04-10-2018'),
	(default,'Fido','Seller','deladela',2,30,1500,'08-10-2018','09-11-2018'),
	(default,'Rogers','Player','deladela',3,20,1520,'12-03-2018','02-01-2019'),
	(default,'Nintend','Electrician','deladela',2,10,2000,'03-04-2018','04-06-2018'),
	(default,'Apple','Player','deladela',3,10,2500,'06-03-2018','08-03-2018'),
	(default,'Fido','Manager','deladela',4,10,20000,'09-10-2018','11-10-2018'),
	(default,'Subway','HR','deladela',3,50,2000,'11-10-2018','01-10-2019'),
	(default,'Pepsi','Designer','deladela',2,100,1000,'06-10-2018','07-10-2018'),
	(default,'Blue 2 Science','Electrician','deladela',3,30,2000,'03-10-2018','04-01-2018'); 
	

INSERT INTO Jobs VALUES
	(1, 'Red 1 Engineering', 'Mechanical designer', 'blabla', 3, 20, 500, '04-03-2018', '04-05-2018'),
	(2, 'Red 1 Engineering', 'Test engineer', 'clacla', 2, 10, 250, '04-03-2018', '04-05-2018'),
	(3, 'Blue 2 Science', 'Electrician', 'deladela', 4, 10, 700, '04-03-2018', '04-04-2018'),
	(4,'Subway','Seller','blabla',3,10,1000,'10-06-2018','11-06-2018'),
	(5,'Hertz','Manager','clacla',2,50,2000,'10-06-2018','11-06-2018'),
	(6,'Apple','Experience staf','deladela',1,100,300,'01-01-2018','05-01-2018'),
	(7,'Apple','Manager','lalala',5,10,1500,'07-07-2018','07-09-2018'),
	(8,'Yahoo','Mechanical designer','deladela',4,10,1000,'01-04-2018','05-02-2018'),
	(9,'Playboy','Clothes designer','deladela',3,10,2000,'07-07-2018','09-07-2018'),
	(10,'IBM','Test engineer','deladela',4,20,1500,'02-01-2018','03-03-2018'),
	(11,'Pepsi','Seller','deladela',4,20,2000,'05-08-2018','06-09-2018'),
	(12,'BestBuy','HR','deladela',1,40,3000,'03-09-2018','04-10-2018'),
	(13,'Fido','Seller','deladela',2,30,1500,'08-10-2018','09-11-2018'),
	(14,'Rogers','Player','deladela',3,20,1520,'12-03-2018','02-01-2019'),
	(15,'Nintend','Electrician','deladela',2,10,2000,'03-04-2018','04-06-2018'); 

INSERT INTO Resume VALUES
	(1, 1,'Cgpa 8/10','Good at databse design and web design','None'),
	(20, 2,'Cgpa 7/10','Good at sports', 'None'),
	(16,3,'Cgpa 4.5/5','have a lot of work experience in group wrok and origztion well','Volutneer lot'),
	(3,4,'Cgpa 3/5','know how to use java,C++,python','build an app using python'),
	(12,5,'Cgpa 6/8','learning and understanfing is very easy for me','work in a resaurant for almost one year'),
	(5,6,'Cgpa 4/5','understand many different software and hardware','work in fido for coop one term'),
	(6,7,'Cgpa 3.5/5','learn a lot knowledge about physchology','Ta experience one term' ),
	(7,8,'Cgpa 2/5','usually organize one acitivity for internation studnents','leader for internation office one year'),
	(8,9,'Cgpa 4/5','always fix my computer and my friends computers problems','fix computer club three months'),
	(9,10,'Cgpa 8/10','work in math career centre','none'),
	(10,11,'Cgpa 4/10','never find a chance to perform myself',' volunteer every semester'),
	(11,12,'Cgpa 7/10','number one in school ping-pong','a ping-pong teacher fore three years'),
	(12,13,'Cgpa 3/5','teach lower level math','none'),
	(13,14,'Cgpa 9/10','know how to design a new website','none' ),
	(14,15,'Cgpa 5/6','overwatch number one','a job helps other people accoun go to higher level'),
	(15,16,'Cgpa 6/8','nothing I want to tell','designer for rogers mobile one time'),
	(16, 17,'Cgpa 4.5/5','have a lot of work experience in group wrok and origztion well','Volutneer lot'),
	(17,18,'Cgpa 7/8','good at study','want work experience'),
	(18,19,'Cgpa 4/5','never give up','work in fido every weekend'),
	(9,20,'Cgpa 8/10','work in math career centre','none'),
	(14,21,'Cgpa 5/6','overwatch number one','a job helps other people accoun go to higher level'),
	(11,22,'Cgpa 7/10','number one in school ping-pong','a ping-pong teacher fore three years'),
	(3,23,'Cgpa 3/5','know how to use java,C++,python','build an app using python'),
	(15,24,'Cgpa 6/8','nothing I want to tell','designer for rogers mobile one time'),
	(5,25,'Cgpa 4/5','understand many different software and hardware','work in fido for coop one term');
	


INSERT INTO ResumeReviewRequest VALUES
	(1, 1),
	(20, 2),
	(16,3),
	(3,4),
	(12,5),
	(5,6),
	(6,7 ),
	(7,8),
	(8,9),
	(9,10),
	(10,11),
	(11,12),
	(12,13),
	(13,14 ),
	(14,15),
	(15,16),
	(16,17),
	(17,18),
	(18,19),
	(9,20),
	(14,21),
	(11,22),
	(3,23),
	(15,24),
	(5,25);
	
	
	

INSERT INTO ResumeReview VALUES
	(1,20, 2,'Good'),
	(2,16,3,'Nice'),
	(3,3,4,'too hard'),
	(4,6,7 ,'Not well'),
	(5,9,10,'Best job'),
	(6,10,11,'too hard'),
	(7,13,14 ,'Can try'),
	(8,14,15,'Not too bad'),
	(9,16,17,'Best job'),
	(10,18,19,'Good');
	
INSERT INTO Review VALUES
	(1, default, 'Red 1 Engineering', '01-05-2018', 'Mechanical designer', 'blabla', 4),
	(3, default, 'Red 1 Engineering', '01-06-2018','Test engineer', 'clacla',3 ),
	(5, default, 'Blue 2 Science','01-05-2018' ,'Electrician', 'deladela', 4),
	(4,default,'Subway','10-11-2018','Seller','blabla',3),
	(8,default,'Hertz','11-11-2018','Manager','clacla',2),
	(6,default,'Apple','01-02-2018','Experience staf','deladela',3),
	(12,default,'Apple','01-10-2018','Manager','lalala',5),
	(14,default,'Yahoo','05-05-2018','Mechanical designer','deladela',3),
	(9,default,'Playboy','01-09-2018','Clothes designer','deladela',4),
	(15,default,'IBM','01-04-2018','Test engineer','deladela',3),
	(20,default,'Pepsi','06-09-2018','Seller','deladela',5),
	(17,default,'BestBuy','04-10-2018','HR','deladela',3),
	(19,default,'Fido','10-11-2018','Seller','deladela',4),
	(11,default,'Rogers','05-01-2019','Player','deladela',3),
	(7,default,'Nintend','05-06-2018','Electrician','deladela',4);
	


INSERT INTO Upvote VALUES
	(1, 1),
	(10, 2),
	(5, 3),
	(4, 4),
	(8, 5),
	(6, 6),
	(12,7),
	(14,8),
	(9,9),
	(15, 10),
	(20,11),
	(17,12),
	(19, 13),
	(11, 14),
	(7, 15);

INSERT INTO Apply VALUES
	(1, 1),
	(1, 8),
	(2, 1),
	(2, 8),
	(3, 3),
	(3, 15),
	(4, 4),
	(4, 13),
	(4, 5),
	(5, 12),
	(6, 6),
	(6, 13),
	(7, 5),
	(8, 1),
	(9, 12),
	(9, 2),
	(10, 1),
	(10, 8),
	(11, 11),
	(11, 13),
	(11, 4),
	(12, 1),
	(12, 8),
	(13, 10),
	(14, 3),
	(14, 15),
	(15, 14),
	(15, 7),
	(16, 1),
	(16, 8),
	(17, 12),
	(17, 9),
	(18, 8),
	(19, 1),
	(20,14),
	(20,8);
	

INSERT INTO Approve VALUES
	(1, 3),
	(2, 1),
	(3, 2),
	(4, 4),
	(5, 8),
	(6, 10),
	(7, 6),
	(8, 12),
	(9, 5),
	(10, 7),
	(6, 9),
	(9,11),
	(10,13),
	(1,14),
	(3,15);
	

INSERT INTO Job_for_program VALUES
	('CSI', 1),
	('SEG',1),
	('CEG',1),
	('GNG',1),
	('CSI', 8),
	('SEG',8),
	('CEG',8),
	('GNG',8),
	('PHY',2),
	('MCG',2),
	('MAT',3),
	('BIO',3),
	('PHI',4),
	('PSY',4),
	('HSS',4),
	('PHI',13),
	('PSY',13),
	('HSS',13),
	('MAT',15),
	('BIO',15),
	('PSY',5),
	('ANP',5),
	('PSY',7),
	('ANP',7),
	('PED',12),
	('PED',9),
	('MAT',9),
	('ANP',6),
	('HSS',6),
	('PHY',10),
	('MCG',10),
	('PHI',11),
	('PSY',11),
	('CSI', 14),
	('PHY',14),
	('PHI',14);

INSERT INTO Rate_Company VALUES
	(1, 'Red 1 Engineering', 2),
	(2, 'Red 1 Engineering', 5),
	(3, 'Blue 2 Science',3),
	(1,'Yahoo',2),
	(2,'Fido',3),
	(10,'Yahoo',4),
	(4,'BestBuy',2),
	(5,'Hertz',2),
	(6,'Rogers',5),
	(7,'Apple',5),
	(8,'IBM',2),
	(9,'Hertz',2),
	(10,'Nintend',5),
	(11,'Fido',3),
	(12,'Rogers',5),
	(13,'Subway',3),
	(14,'IBM',3),
	(15,'Pepsi',4),
	(16,'Playboy',5),
	(17,'Apple',4),
	(18,'Playboy',2),
	(19,'Subway',3),
	(20,'Blue 2 Science',4);
 
INSERT INTO Does VALUES
	(1, 1),
	(2, 8),
	(4, 4),
	(5, 12),
	(6, 6),
	(6, 13),
	(7, 5),
	(8, 1),
	(3, 1),
	(11, 4),
	(12, 1),
	(13, 10),
	(14, 3),
	(15, 7),
	(17, 9),
	(18, 2),
	(20,8);
DROP TABLE Apply;
DROP TABLE Approve;
DROP TABLE Does;
DROP TABLE Job_for_program;
DROP TABLE Upvote;
DROP TABLE Review;
DROP TABLE ResumeReview;
DROP TABLE ResumeReviewRequest;
DROP TABLE Resume;
DROP TABLE Jobs;
DROP TABLE Rate_Company;
DROP TABLE JobPending;
DROP TABLE Company;
DROP TABLE Student;
DROP TABLE Admin;
DROP TABLE Moderator;
DROP TABLE Program;
DROP TABLE Users;




