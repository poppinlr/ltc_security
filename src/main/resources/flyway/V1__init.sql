CREATE TABLE `access` (
  `access_id`   INT(11)     NOT NULL AUTO_INCREMENT,
  `access_name` VARCHAR(45) NOT NULL,
  `menu_id`     INT(11)              DEFAULT NULL,
  `active`      TINYINT(1)           DEFAULT 1,
  `created_at`  DATETIME(6) NOT NULL,
  `modified_at` DATETIME(6) NOT NULL,
  `created_by`  INT(11)     NOT NULL,
  `modified_by` INT(11)     NOT NULL,
  PRIMARY KEY (`access_id`)
)
  ENGINE = InnoDB
  CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE `role` (
  `role_id`     INT(11)     NOT NULL AUTO_INCREMENT,
  `role_name`   VARCHAR(45) NOT NULL,
  `comment`     VARCHAR(255)         DEFAULT NULL,
  `active`      TINYINT(1)           DEFAULT 1,
  `company_id`  INT(11)              DEFAULT NULL,
  `created_at`  DATETIME(6) NOT NULL,
  `modified_at` DATETIME(6) NOT NULL,
  `created_by`  INT(11)     NOT NULL,
  `modified_by` INT(11)     NOT NULL,
  PRIMARY KEY (`role_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE `access_role` (
  `access_role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `access_id`      INT(11) NOT NULL,
  `role_id`        INT(11) NOT NULL,
  PRIMARY KEY (`access_role_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE `menu` (
  `menu_id`     INT(11)     NOT NULL AUTO_INCREMENT,
  `menu_name`   VARCHAR(45)          DEFAULT NULL,
  `parent_id`   INT(11)              DEFAULT NULL,
  `url`         VARCHAR(255)         DEFAULT NULL,
  `icon`        VARCHAR(45)          DEFAULT NULL,
  `active`      TINYINT(1)           DEFAULT 1,
  `created_at`  DATETIME(6) NOT NULL,
  `modified_at` DATETIME(6) NOT NULL,
  `created_by`  INT(11)              DEFAULT NULL,
  `modified_by` INT(11)              DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE `user_login` (
  `user_id`     INT(11)       NOT NULL AUTO_INCREMENT,
  `username`    VARCHAR(45)   NOT NULL,
  `name`        VARCHAR(45)            DEFAULT NULL,
  `email`       VARCHAR(45)            DEFAULT NULL,
  `password`    VARBINARY(45) NOT NULL,
  `role_id`     INT(11)                DEFAULT NULL,
  `company_id`  INT(11)                DEFAULT NULL,
  `active`      TINYINT(1)             DEFAULT 1,
  `created_at`  DATETIME(6)   NOT NULL,
  `modified_at` DATETIME(6)   NOT NULL,
  `created_by`  INT(11)                DEFAULT NULL,
  `modified_by` INT(11)                DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_login_unique_index_1` (`username`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE `company` (
  `company_id`   INT(11)     NOT NULL AUTO_INCREMENT,
  `company_name` VARCHAR(45) NOT NULL,
  `level`        INT(11)     NOT NULL,
  `parent_id`    INT(11)              DEFAULT NULL,
  `active`       TINYINT(1)           DEFAULT 1,
  `created_at`   DATETIME(6) NOT NULL,
  `modified_at`  DATETIME(6) NOT NULL,
  `created_by`   INT(11)              DEFAULT NULL,
  `modified_by`  INT(11)              DEFAULT NULL,
  PRIMARY KEY (`company_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE `ltc_security`.`evaluate_organize` (
  `evaluate_organize_id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(100) NOT NULL COMMENT '机构编号',
  `name` VARCHAR(100) NOT NULL COMMENT '机构名称',
  `type` INT NOT NULL COMMENT '机构类型(公立,私立)',
  `address` VARCHAR(255) NOT NULL COMMENT '机构地址',
  `organizer` VARCHAR(45) NOT NULL COMMENT '负责人姓名',
  `organizer_phone` VARCHAR(45) NULL COMMENT '负责人电话',
  `legal_representative` VARCHAR(45) NOT NULL COMMENT '法人姓名',
  `legal_representative_phone` VARCHAR(45) NULL COMMENT '法人电话',
  `company_id` int(11) NOT NULL,
  `active` tinyint(1) DEFAULT 1,
  `created_at` DATETIME(6) NOT NULL,
  `modified_at` DATETIME(6) NOT NULL,
  `created_by` int(11) NOT NULL,
  `modified_by` int(11) NOT NULL,
  PRIMARY KEY (`evaluate_organize_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

CREATE TABLE `ltc_security`.`organize_expert` (
  `organize_expert_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL COMMENT '专家姓名',
  `phone` VARCHAR(45) NOT NULL COMMENT '专家电话',
  `type` TINYINT(4) NOT NULL COMMENT '专家类型',
  `onJob` TINYINT(1) NOT NULL COMMENT '在职状态',
  `IDNumber` VARCHAR(45) NOT NULL COMMENT '身份证',
  `gender` TINYINT(1) NULL COMMENT '性别',
  `position` VARCHAR(45) NULL COMMENT '职位',
  `title` VARCHAR(45) NULL COMMENT '职称',
  `personalPhone` int(11) NOT NULL COMMENT '私人电话',
  `education` VARCHAR(45) COMMENT '学历',
  `degree` VARCHAR(45) COMMENT '学位',
  `employeeNumber` VARCHAR(45) NULL COMMENT '员工号',
  `workingAge` int(11) NULL COMMENT '工龄',
  `certificate` VARCHAR(45) NULL COMMENT '证书',
  `certificateNumber` VARCHAR(45) NULL COMMENT '证书编号',
  `comment` VARCHAR(255) NULL,
  `active` tinyint(1) DEFAULT 1,
  `created_at` DATETIME(6) NOT NULL,
  `modified_at` DATETIME(6) NOT NULL,
  `created_by` int(11) NOT NULL,
  `modified_by` int(11) NOT NULL,
  PRIMARY KEY (`organize_expert_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_bin;

-- ----------------------------------------------------------------------------------------------------
-- init admin user , role
-- init 总公司
-- ----------------------------------------------------------------------------------------------------
INSERT INTO `ltc_security`.`user_login`
(`user_id`, `username`, `password`, `role_id`, `company_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES (1, 'admin', AES_ENCRYPT('admin', 'af62321a3e94793c'), 1, 1, 1, now(), now(), 0, 0);

INSERT INTO `ltc_security`.`role`
(`role_id`, `role_name`, `comment`, `active`, `company_id`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES (1, 'admin', 'admin role', 1, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`company`
(`company_id`, `company_name`, `level`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES (1, '总公司', 0, 1, now(), now(), 1, 1);

-- ----------------------------------------------------------------------------------------------------
-- init menu
-- ----------------------------------------------------------------------------------------------------
INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('大数据分析', '/dashboard', 'laptop', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('菜单管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '公司管理',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '菜单管理'),
    '/mainManage/companyManage',
    'heart-o',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '角色管理',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '菜单管理'),
    '/mainManage/roleManage',
    'heart-o',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '用户管理',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '菜单管理'),
    '/mainManage/rolesManage',
    'heart-o',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('项目管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '项目申请',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '项目管理'),
    '/agreementManage',
    'heart-o',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('协议管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '协议申请管理',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '协议管理'),
    '/agreementManage',
    'heart-o',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估管理', '/', 'camera-o', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '评估申请',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '评估管理'),
    '/evaluationApply',
    'heart-o',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '评估工单管理',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '评估管理'),
    '/evaluationManage',
    'heart-o',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '服务项目配置',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务管理'),
    '/serviceManage/projectConfig',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '服务包配置',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务管理'),
    '/serviceManage/serviceConfig',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '服务计划制定',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务管理'),
    '/serviceManage/planMake',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '服务计划查看',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务管理'),
    '/serviceManage/planView',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '服务计划执行',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务管理'),
    '/serviceManage/planPerform',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '服务机构变更',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务管理'),
    '/serviceManage/changeInstitution',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '服务计划变更',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务管理'),
    '/serviceManage/changePlan',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('出入院管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '入院登记',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '出入院管理'),
    '/hospitalManage/inHospital',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '出院管理',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '出入院管理'),
    '/hospitalManage/outHospital',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估结算管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '评估费用结算',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '评估结算管理'),
    '/evaluateSettlement/settlement',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '生成评估费用结算单',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '评估结算管理'),
    '/evaluateSettlement/listing',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务结算管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '服务费用结算',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务结算管理'),
    '/serviceSettlement/settlement',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '生成护理费用结算单',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务结算管理'),
    '/serviceSettlement/listing',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '参保人信息维护',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '参保人管理'),
    '/peopleManage/infoMaintenance',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '参保人个人帐户',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '参保人管理'),
    '/peopleManage/privateAccounts',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '参保人黑名单',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '参保人管理'),
    '/peopleManage/blacklist',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('两定机构协议管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '评估机构协议配置',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '两定机构协议管理'),
    '/protocolConfig/evaluateConfig',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '护理机构协议配置',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '两定机构协议管理'),
    '/protocolConfig/serviceConfig',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '评估机构配置',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '评估机构管理'),
    '/evaluationInstitutionsConfig/institution',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '评估人员配置',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '评估机构管理'),
    '/evaluationInstitutionsConfig/workers',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务机构管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '护理机构配置',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务机构管理'),
    '/serviceInstitutionsConfig/institution',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '护理人员配置',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '服务机构管理'),
    '/serviceInstitutionsConfig/workers',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('大数据管理', '/', 'database', 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '评估机构质量分析',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '大数据管理'),
    'user',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '护理机构质量分析',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '大数据管理'),
    'user',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '参保人群分析',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '大数据管理'),
    'user',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '评估结果质量分析',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '大数据管理'),
    'user',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '评估费用分析',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '大数据管理'),
    'user',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '护理费用分析',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '大数据管理'),
    'user',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '基金使用率与结余分析',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '大数据管理'),
    'user',
    'database',
    1,
    now(),
    now(),
    1,
    1;

INSERT INTO `ltc_security`.`menu`
(`menu_name`, `parent_id`, `url`, `icon`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
  SELECT
    '费用预警配置',
    (SELECT menu_id
     FROM menu
     WHERE menu_name = '大数据管理'),
    'user',
    'database',
    1,
    now(),
    now(),
    1,
    1;

-- ----------------------------------------------------------------------------------------------------
-- menu view access init
-- ----------------------------------------------------------------------------------------------------
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('大数据分析', 1, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('大数据分析增加', 1, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('大数据分析修改', 1, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('大数据分析删除', 1, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('菜单管理', 2, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('菜单管理增加', 2, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('菜单管理修改', 2, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('菜单管理删除', 2, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('公司管理', 3, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('公司管理增加', 3, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('公司管理修改', 3, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('公司管理删除', 3, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('角色管理', 4, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('角色管理增加', 4, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('角色管理修改', 4, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('角色管理删除', 4, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('用户管理', 5, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('用户管理增加', 5, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('用户管理修改', 5, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('用户管理删除', 5, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('项目管理', 6, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('项目管理增加', 6, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('项目管理修改', 6, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('项目管理删除', 6, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('项目申请', 7, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('项目申请增加', 7, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('项目申请修改', 7, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('项目申请删除', 7, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('协议管理', 8, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('协议管理增加', 8, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('协议管理修改', 8, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('协议管理删除', 8, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('协议申请管理', 9, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('协议申请管理增加', 9, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('协议申请管理修改', 9, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('协议申请管理删除', 9, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估管理', 10, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估管理增加', 10, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估管理修改', 10, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估管理删除', 10, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估申请', 11, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估申请增加', 11, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估申请修改', 11, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估申请删除', 11, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估工单管理', 12, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估工单管理增加', 12, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估工单管理修改', 12, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估工单管理删除', 12, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务管理', 13, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务管理增加', 13, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务管理修改', 13, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务管理删除', 13, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务项目配置', 14, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务项目配置增加', 14, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务项目配置修改', 14, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务项目配置删除', 14, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务包配置', 15, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务包配置增加', 15, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务包配置修改', 15, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务包配置删除', 15, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划制定', 16, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划制定增加', 16, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划制定修改', 16, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划制定删除', 16, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划查看', 17, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划执行', 18, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划执行增加', 18, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划执行修改', 18, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划执行删除', 18, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务机构变更', 19, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务机构变更增加', 19, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务机构变更修改', 19, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务机构变更删除', 19, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划变更', 20, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划变更增加', 20, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划变更修改', 20, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务计划变更删除', 20, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('出入院管理', 21, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('出入院管理增加', 21, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('出入院管理修改', 21, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('出入院管理删除', 21, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('入院登记', 22, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('入院登记增加', 22, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('入院登记修改', 22, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('入院登记删除', 22, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('出院管理', 23, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('出院管理增加', 23, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('出院管理修改', 23, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('出院管理删除', 23, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估结算管理', 24, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估结算管理增加', 24, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估结算管理修改', 24, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估结算管理删除', 24, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估费用结算', 25, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估费用结算增加', 25, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估费用结算修改', 25, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估费用结算删除', 25, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('生成评估费用结算单', 26, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('生成评估费用结算单增加', 26, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('生成评估费用结算单修改', 26, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('生成评估费用结算单删除', 26, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务结算管理', 27, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务结算管理增加', 27, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务结算管理修改', 27, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务结算管理删除', 27, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务费用结算', 28, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务费用结算增加', 28, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务费用结算修改', 28, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务费用结算删除', 28, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('生成护理费用结算单', 29, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('生成护理费用结算单增加', 29, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('生成护理费用结算单修改', 29, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('生成护理费用结算单删除', 29, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人管理', 30, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人管理增加', 30, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人管理修改', 30, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人管理删除', 30, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人信息维护', 31, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人信息维护增加', 31, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人信息维护修改', 31, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人信息维护删除', 31, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人个人帐户', 32, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人个人帐户增加', 32, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人个人帐户修改', 32, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人个人帐户删除', 32, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人黑名单', 33, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人黑名单增加', 33, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人黑名单修改', 33, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人黑名单删除', 33, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('两定机构协议管理', 34, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('两定机构协议管理增加', 34, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('两定机构协议管理修改', 34, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('两定机构协议管理删除', 34, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构协议配置', 35, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构协议配置增加', 35, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构协议配置修改', 35, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构协议配置删除', 35, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理机构协议配置', 36, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理机构协议配置增加', 36, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理机构协议配置修改', 36, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理机构协议配置删除', 36, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构管理', 37, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构管理增加', 37, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构管理修改', 37, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构管理删除', 37, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构配置', 38, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构配置增加', 38, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构配置修改', 38, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构配置删除', 38, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估人员配置', 39, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估人员配置增加', 39, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估人员配置修改', 39, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估人员配置删除', 39, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务机构管理', 40, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务机构管理增加', 40, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务机构管理修改', 40, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('服务机构管理删除', 40, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理机构配置', 41, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理机构配置增加', 41, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理机构配置修改', 41, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理机构配置删除', 41, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理人员配置', 42, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理人员配置增加', 42, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理人员配置修改', 42, 1, now(), now(), 1, 1);
INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理人员配置删除', 42, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('大数据管理', 43, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估机构质量分析', 44, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理机构质量分析', 45, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('参保人群分析', 46, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估结果质量分析', 47, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('评估费用分析', 48, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('护理费用分析', 49, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('基金使用率与结余分析', 50, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access`
(`access_name`, `menu_id`, `active`, `created_at`, `modified_at`, `created_by`, `modified_by`)
VALUES ('费用预警配置', 51, 1, now(), now(), 1, 1);

INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (1, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (2, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (3, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (4, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (5, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (6, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (7, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (8, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (9, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (10, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (11, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (12, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (13, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (14, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (15, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (16, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (17, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (18, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (19, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (20, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (21, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (22, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (23, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (24, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (25, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (26, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (27, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (28, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (29, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (30, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (31, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (32, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (33, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (34, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (35, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (36, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (37, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (38, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (39, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (40, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (41, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (42, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (43, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (44, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (45, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (46, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (47, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (48, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (49, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (50, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (51, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (52, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (53, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (54, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (55, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (56, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (57, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (58, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (59, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (60, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (61, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (62, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (63, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (64, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (65, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (66, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (67, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (68, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (69, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (70, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (71, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (72, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (73, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (74, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (75, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (76, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (77, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (78, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (79, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (80, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (81, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (82, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (83, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (84, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (85, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (86, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (87, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (88, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (89, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (90, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (91, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (92, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (93, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (94, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (95, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (96, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (97, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (98, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (99, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (100, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (101, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (102, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (103, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (104, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (105, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (106, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (107, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (108, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (109, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (110, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (111, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (112, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (113, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (114, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (115, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (116, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (117, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (118, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (119, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (120, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (121, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (122, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (123, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (124, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (125, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (126, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (127, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (128, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (129, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (130, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (131, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (132, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (133, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (134, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (135, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (136, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (137, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (138, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (139, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (140, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (141, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (142, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (143, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (144, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (145, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (146, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (147, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (148, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (149, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (150, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (151, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (152, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (153, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (154, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (155, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (156, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (157, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (158, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (159, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (160, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (161, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (162, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (163, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (164, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (165, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (166, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (167, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (168, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (169, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (170, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (171, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (172, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (173, 1);
INSERT INTO `ltc_security`.`access_role` (`access_id`, `role_id`) VALUES (174, 1);





