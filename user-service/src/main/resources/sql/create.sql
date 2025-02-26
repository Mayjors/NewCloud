CREATE TABLE `sys_user` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人',
                            `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;


INSERT INTO `sys_user`.`sys_user`(`id`, `username`, `address`) VALUES (1, '柳岩', '湖南省衡阳市');
INSERT INTO `sys_user`.`sys_user`(`id`, `username`, `address`) VALUES (2, '文二狗', '陕西省西安市');
INSERT INTO `sys_user`.`sys_user`(`id`, `username`, `address`) VALUES (3, '华沉鱼', '湖北省十堰市');
INSERT INTO `sys_user`.`sys_user`(`id`, `username`, `address`) VALUES (4, '张必沉', '天津市');
INSERT INTO `sys_user`.`sys_user`(`id`, `username`, `address`) VALUES (5, '郑爽爽', '辽宁省沈阳市大东区');
INSERT INTO `sys_user`.`sys_user`(`id`, `username`, `address`) VALUES (6, '范兵兵', '山东省青岛市');

