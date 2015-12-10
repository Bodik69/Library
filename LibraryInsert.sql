INSERT INTO `testhibernate`.`author` (`firstname`, `lastname`) VALUES ('Стівен', 'Кінг');
INSERT INTO `testhibernate`.`author` (`firstname`, `lastname`) VALUES ('Тарас', 'Шевченко');
INSERT INTO `testhibernate`.`author` (`firstname`, `lastname`) VALUES ('Макс', 'Кідрук');
INSERT INTO `testhibernate`.`author` (`firstname`, `lastname`) VALUES ('Віьльям', 'Голдинг');
INSERT INTO `testhibernate`.`author` (`firstname`, `lastname`) VALUES ('Іван', 'Франко');
INSERT INTO `testhibernate`.`author` (`firstname`, `lastname`) VALUES ('Джордж', 'Мартін');
INSERT INTO `testhibernate`.`author` (`firstname`, `lastname`) VALUES ('Леся', 'Українка');


INSERT INTO `testhibernate`.`reader` (`name`,`surname`,`adress`,`phone`,`birth`,`dateOfCreate`) VALUES ('Ігор','Соколик','Львів','80993235754','1993-02-04','2014-06-04');
INSERT INTO `testhibernate`.`reader` (`name`,`surname`,`adress`,`phone`,`birth`,`dateOfCreate`) VALUES ('Тарас','Іванов','Стрий','80935485454','1994-12-02','2014-08-04');
INSERT INTO `testhibernate`.`reader` (`name`,`surname`,`adress`,`phone`,`birth`,`dateOfCreate`) VALUES ('Руслан','Башенський','Львів','80508754542','1993-07-04','2014-05-04');
INSERT INTO `testhibernate`.`reader` (`name`,`surname`,`adress`,`phone`,`birth`,`dateOfCreate`) VALUES ('Богдан','Смачило','Львів','80935487546','1995-07-06','2014-02-04');
INSERT INTO `testhibernate`.`reader` (`name`,`surname`,`adress`,`phone`,`birth`,`dateOfCreate`) VALUES ('Марія','Борис','Тернопіль','80696434688','1993-06-13','2014-11-04');



INSERT INTO `testhibernate`.`book` (`code`,`title`,`idAuthor`,`edition`,`year`,`pages`,`copyCount`) VALUES ('1','Зона покриття',2,'КСД',2008,346,2);
INSERT INTO `testhibernate`.`book` (`code`,`title`,`idAuthor`,`edition`,`year`,`pages`,`copyCount`) VALUES ('2','Кобзар',1,'Світанок',2010,401,3);
INSERT INTO `testhibernate`.`book` (`code`,`title`,`idAuthor`,`edition`,`year`,`pages`,`copyCount`) VALUES ('3','Бот',4,'КСД',2014,412,2);
INSERT INTO `testhibernate`.`book` (`code`,`title`,`idAuthor`,`edition`,`year`,`pages`,`copyCount`) VALUES ('4','Володар мух',3,'КСД',2015,278,2);
INSERT INTO `testhibernate`.`book` (`code`,`title`,`idAuthor`,`edition`,`year`,`pages`,`copyCount`) VALUES ('5','Під куполом',5,'КСД',2011,1024,2);


INSERT INTO `testhibernate`.`author_book` (`idAuthor`, `code`) VALUES ('1', '1');
INSERT INTO `testhibernate`.`author_book` (`idAuthor`, `code`) VALUES ('2', '1');
INSERT INTO `testhibernate`.`author_book` (`idAuthor`, `code`) VALUES ('3', '2');
INSERT INTO `testhibernate`.`author_book` (`idAuthor`, `code`) VALUES ('3', '3');
INSERT INTO `testhibernate`.`author_book` (`idAuthor`, `code`) VALUES ('4', '2');
INSERT INTO `testhibernate`.`author_book` (`idAuthor`, `code`) VALUES ('5', '5');
INSERT INTO `testhibernate`.`author_book` (`idAuthor`, `code`) VALUES ('6', '4');


INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('11', '1', 1);
INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('12', '1', 0);
INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('21', '2', 0);
INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('22', '2', 1);
INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('23', '2', 1);
INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('31', '3', 0);
INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('32', '3', 0);
INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('41', '4', 1);
INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('42', '4', 0);
INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('51', '5', 0);
INSERT INTO `testhibernate`.`copy` (`inventoryNumber`, `code`, `isInStock`) VALUES ('52', '5', 0);

INSERT INTO `testhibernate`.`orderreader` (`idReader`, `inventoryNumber`, `dataOrder`, `dataReturn`) VALUES ('4', '21', '2015-04-25', '2015-05-25');
INSERT INTO `testhibernate`.`orderreader` (`idReader`, `inventoryNumber`, `dataOrder`, `dataReturn`) VALUES ('1', '51', '2015-06-12', '2015-07-12');
INSERT INTO `testhibernate`.`orderreader` (`idReader`, `inventoryNumber`, `dataOrder`, `dataReturn`) VALUES ('3', '32', '2015-08-22', '2015-09-22');
INSERT INTO `testhibernate`.`orderreader` (`idReader`, `inventoryNumber`, `dataOrder`, `dataReturn`) VALUES ('2', '31', '2015-09-01', '2015-10-01');
INSERT INTO `testhibernate`.`orderreader` (`idReader`, `inventoryNumber`, `dataOrder`, `dataReturn`) VALUES ('4', '42', '2015-09-12', '2015-10-12');
INSERT INTO `testhibernate`.`orderreader` (`idReader`, `inventoryNumber`, `dataOrder`, `dataReturn`) VALUES ('5', '21', '2015-10-02', '2015-11-02');
INSERT INTO `testhibernate`.`orderreader` (`idReader`, `inventoryNumber`, `dataOrder`, `dataReturn`) VALUES ('5', '12', '2015-10-11', '2015-11-11');
INSERT INTO `testhibernate`.`orderreader` (`idReader`, `inventoryNumber`, `dataOrder`, `dataReturn`) VALUES ('1', '21', '2015-11-06', '2015-12-06');
INSERT INTO `testhibernate`.`orderreader` (`idReader`, `inventoryNumber`, `dataOrder`, `dataReturn`) VALUES ('4', '52', '2015-11-22', '2015-12-22');
