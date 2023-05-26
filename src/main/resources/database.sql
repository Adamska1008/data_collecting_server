# 1:呼吸机 2:血氧仪 3:肺功能仪 4:空气净化器 5:温湿度计
DROP TABLE sensor;
create table sensor(
    id INTEGER PRIMARY KEY ,
    type INTEGER CHECK ( type IN (1,2,3,4,5))
);

DROP TABLE sensor_data;
create table sensor_data(
    sensor_id INTEGER,
    acquisition_time DATETIME,
    real_time_data VARCHAR(200)
);

DROP TABLE client;
create table client(
    client_id INTEGER PRIMARY KEY ,
    client_name VARCHAR(20)
);
DROP TABLE subscribe;
# 订阅表
create table subscribe(
    client_id INTEGER,
    sensor_id INTEGER
);

DROP TABLE questionnaire;
# 调查问卷
CREATE TABLE questionnaire (
    name VARCHAR(20),
    gender VARCHAR(5),
    height VARCHAR(5),
    weight VARCHAR(5),
    age VARCHAR(5),
    Mood VARCHAR(50),
    diet VARCHAR(50),
    illness VARCHAR(50),
    sleep VARCHAR(5)

)