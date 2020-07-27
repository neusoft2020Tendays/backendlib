基本信息（主要提供系统的基本信息的设定及系统初始化操作、功能主要包括收费类型、民族、学历、婚姻状况、护理级别、系统初始化）

1. checkin
   1. 房间管理room（**房间号ROOM**，楼层FLOOR，床位数BEDNUM）w
   2. 床位管理bed（**床位号ID**，*房间ROOM*）b
   3. 老人管理elderly（**老人ID**，*床位号bedid*，性别SEX，年龄AGE）s
   4. 收费管理cost（**收费ID**，*老人ID*，收费金额AMOUNT，收费时间TIME）l
   5. 接待管理guest（**接待ID**，*老人ID*，来访人员数量NUM，来访人员身份IDENTITY）w
2. hr
   1. 人事管理hr（**员工empid**，*部门deptid*，性别SEX，年龄AGE，离职状态FIRED，请假LEAVE）b
   2. 工资管理salary（**工资ID**，*员工ID*，工资支付AMOUNT，支付时间TIME）l
   3. 部门管理department（**部门ID**，部门名称NAME）s

收支情况报表、床位可视化

