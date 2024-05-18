create type TASKSTATUS as enum ('TO_DO', 'IN_PROGRESS', 'DONE');

CREATE TABLE tasks (
                         id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         task_name VARCHAR(50) NOT NULL,
                         task_discription VARCHAR(50) NOT NULL,
                         task_status TASKSTATUS,
                         creation_time smalldatetime NOT NULL,
                         compltion_time smalldatetime NOT NULL
);