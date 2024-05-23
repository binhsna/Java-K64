
USE master;
GO
IF DB_ID('JavaSwingExam') IS NOT NULL
	DROP DATABASE JavaSwingExam
GO
CREATE DATABASE JavaSwingExam
GO
USE JavaSwingExam;
GO
CREATE TABLE student (
	maSoLop VARCHAR(20) PRIMARY KEY,
	tenLop VARCHAR(50),
	gvcn VARCHAR(40)
)
GO
INSERT INTO dbo.student(maSoLop, tenLop, gvcn)
VALUES('1','64PM1','Nguyen Thi Tuyet'),
('2','64IT1','Nguyen Thanh Ban'),
('3','64IT2','Nguyen Hong Nhung'),
('4','64IT3','Nguyen Thanh Tam'),
('5','64IT4','Nguyen Thi An'),
('6','64IT5','Nguyen Thanh Ban');
GO
SELECT*FROM STUDENT;
go
create table truyvan
(
	ketqua int primary key
)
go
insert into truyvan values(1),(0)
go
select * from truyvan
go
alter proc testproc(@abc int)
as
begin
	if(@abc = 1)
	select cast(1 as int) as ketqua
	else if(@abc = 0)
	select cast(0 as int) as ketqua
end
go
EXECUTE testproc 1
