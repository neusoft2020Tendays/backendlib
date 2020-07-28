基本信息（主要提供系统的基本信息的设定及系统初始化操作、功能主要包括收费类型、民族、学历、婚姻状况、护理级别、系统初始化）

1. checkin
   1. 房间管理room（**房间号roomid**，楼层floor，床位数bednum）王航
   2. 床位管理bed（**床位号bedid**，*房间roomid*）霸晨民
   3. 老人管理elderly（**老人elderlyid**，*床位号bedid*，性别sex，年龄age）沈子鸣
   4. 收费管理cost（**收费costid**，*老人elderlyid*，收费金额amount，收费时间time）李佳朋
   5. 接待管理guest（**接待guestid**，*老人elderlyid*，来访人员数量num，来访人员身份identity）王航
2. hr
   1. 人事管理hr（**员工empid**，*部门deptid*，姓名name，性别sex，年龄age，离职状态fired，请假vacation）霸晨民
   2. 工资管理salary（**工资salaryid**，*员工empid*，工资支付amount，支付时间time）李佳朋
   3. 部门管理department（**部门deptid**，部门名称name）沈子鸣
3. store
   1. 仓库管理warehouse（**仓库号warehouseid**，*仓库负责人empid*，仓库地址address）王航
   2. 货物管理goods（**货物号goodsid**，货物名称name，货物单价price）李佳朋
   3. 货物存放placement（**货物号goodsid**，**仓库号warehouseid**，存放数量amount）霸晨民
   4. 货物购买信息purchase（**货物号goodsid**，**购买时间date**，购买额amount）沈子鸣
   5. 货物使用信息consume（**货物号goodsid**，**使用时间date**，使用额amount）沈子鸣

收支情况报表、床位可视化

