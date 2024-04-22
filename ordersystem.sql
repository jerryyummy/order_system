
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(10) DEFAULT NULL,
  `url_ image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  CREATE INDEX idx_username ON user(username);

) ;

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
  `dishId` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `introduce` varchar(255) NOT NULL,
  `isRecommend` boolean default false,
  `price` float(100,0) NOT NULL,
  `url_dish` varchar(255) default null,
  PRIMARY KEY (`dishId`),
  CREATE INDEX idx_name ON dish(name);

) ;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` varchar(255) not NULL,
  `text` varchar(255) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `publisher` varchar(255) not NULL,
  PRIMARY KEY (`id`)
) ;

-- ----------------------------
-- Table structure for order_table
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderId` varchar(255) NOT NULL,
  `userId` varchar(255) NOT NULL ,
  `table_number` int(10) DEFAULT 0,
  `sum` float(100,0) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `updateTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  Foreign key (`userId`) REFERENCES user(`userId`),
  CREATE INDEX idx_userid ON order(userId),
  CREATE INDEX idx_status ON order(status),
  CREATE INDEX idx_createTime ON order(createTime);

) ;


-- ----------------------------
-- Table structure for order_DETAIL
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`
(
    `Id`      varchar(255) NOT NULL,
    `orderId` varchar(255) not null ,
    `amount`  int(100) DEFAULT 0,
    `dishId`  varchar(255) NOT NULL,
    `status`  int(10)  DEFAULT 0,
    PRIMARY KEY (`Id`),
    Foreign key (dishId) REFERENCES dish (dishId),
    Foreign key (orderId) REFERENCES order (orderId),
    CREATE INDEX idx_orderId ON order_detail(orderId),
    CREATE INDEX idx_dishId ON order_detail(dishId);

) ;