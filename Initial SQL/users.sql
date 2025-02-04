CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL COMMENT '采用 Bcrypt 加密存储',
    email VARCHAR(100) UNIQUE,
    role VARCHAR(20) DEFAULT 'USER' COMMENT '角色字段（USER/ADMIN）', 
    created_user VARCHAR(20) COMMENT '日志-创建人',
		created_time DATETIME COMMENT '日志-创建时间',
		modified_user VARCHAR(20) COMMENT '日志-最后修改执行人',
		modified_time DATETIME COMMENT '日志-最后修改时间',
) ENGINE=InnoDB DEFAULT CHARSET=utf8;