
DROP TABLE IF EXISTS t_alternate_subject;

DROP TABLE IF EXISTS t_basic_subject;

DROP TABLE IF EXISTS t_student;


CREATE TABLE t_student (
  id bigint NOT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE t_basic_subject (
  id bigint NOT NULL,
  name varchar(255) DEFAULT NULL,
  student_id bigint DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_student_subject (student_id),
  CONSTRAINT fk_student_subject FOREIGN KEY (student_id) REFERENCES t_student (id)
);

CREATE TABLE t_alternate_subject (
  id bigint NOT NULL,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_subject_basic_alternate FOREIGN KEY (id) REFERENCES t_basic_subject (id)
);