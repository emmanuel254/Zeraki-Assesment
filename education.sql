CREATE DATABASE IF NOT EXISTS education;

-- CREATE INSTITUTION TABLE IF IT DOES NOT EXIST
CREATE TABLE IF NOT EXISTS education.institution (
  institutionid int(11) NOT NULL,
  name varchar(250) NOT NULL,
    
  PRIMARY KEY (institutionid)
);

-- CREATE COURSE TABLE IF IT DOES NOT EXIST
CREATE TABLE IF NOT EXISTS education.course (
  courseid int(11) NOT NULL,
  name varchar(250) NOT NULL,
  institution int(11) NOT NULL,
    
  PRIMARY KEY (courseid),
    
  FOREIGN KEY (institution) REFERENCES institution(institutionid)
);

-- CREATE STUDENT TABLE IF IT DOES NOT EXIST
CREATE TABLE IF NOT EXISTS education.student (
  studentid int(11) NOT NULL,
  name varchar(255) NOT NULL,
  course int(11) NOT NULL,
    
  PRIMARY KEY (studentid),
    
  FOREIGN KEY (course) REFERENCES course(courseid)
);

-- SELECT, JOIN THE 3 TABLES ABOVE BY THE HELP OF FOREIGN KEYS
SELECT institution.name AS 'INSTITUTION NAME', course.name AS 'COURSE NAME', COUNT(student.course) AS 'NUMBER OF STUDENTS'
FROM ((course
INNER JOIN institution ON course.institution=institution.institutionid)
LEFT JOIN student ON course.courseid = student.course)
GROUP BY 1