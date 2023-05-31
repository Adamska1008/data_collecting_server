use test;
INSERT INTO sensor_data(sensor_id, acquisition_time, real_time_data)
VALUES (1, '2020-1-2 12:04:23', '{"id":"空气净化器No.1","time":"2023-05-29 14:20:03.421","data":{"氧浓度":"6"}}');
INSERT INTO sensor_data(sensor_id, acquisition_time, real_time_data)
VALUES (1, '2020-1-3 12:04:23', '{"id":"空气净化器No.1","time":"2023-05-30 14:20:03.421","data":{"氧浓度":"6"}}');
INSERT INTO sensor_data(sensor_id, acquisition_time, real_time_data)
VALUES (1, '2020-1-24 1:02:55', '{"id":"呼吸机No.1","time":"2023-05-30 14:20:03.421","data":{"呼吸频率":"55","潮气量":"9","氧浓度":"49"}}');
INSERT INTO sensor_data(sensor_id, acquisition_time, real_time_data)
VALUES (1, '2020-1-24 1:02:55', '{"id":"温湿度计No.1","time":"2023-05-28 14:20:03.421","data":{"温度":"25"}}');
