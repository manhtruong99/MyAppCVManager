-- Tạo cơ sở dữ liệu mới
CREATE DATABASE BaiTech;
GO
USe BaiTech
GO 

-- Tạo bảng Roles
CREATE TABLE Roles (
    role_id INT PRIMARY KEY IDENTITY(1,1),
    ma VARCHAR(50) NOT NULL ,  -- Đảm bảo cột ma là duy nhất
    authority VARCHAR(50) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    deleted_at BIT DEFAULT 0
);


-- Tạo bảng Account
CREATE TABLE Account (
    ma VARCHAR(50) PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(50),
    passwords VARCHAR(200),
    enableds BIT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    deleted_at BIT DEFAULT 0
);

-- Tạo bảng account_roles
CREATE TABLE account_roles (
    account_id VARCHAR(50),
    role_id INT,
    CONSTRAINT PK_account_roles PRIMARY KEY (account_id, role_id),
    CONSTRAINT FK_account FOREIGN KEY (account_id) REFERENCES Account(ma),
    CONSTRAINT FK_role FOREIGN KEY (role_id) REFERENCES Roles(role_id)
);


-- Tạo bảng PhongBan
CREATE TABLE PhongBan (
    phong_ban_id INT PRIMARY KEY IDENTITY(1,1),
    ma_phong_ban NVARCHAR(10) NOT NULL UNIQUE,
    ten_phong_ban NVARCHAR(100) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    deleted_at BIT DEFAULT 0
);

-- Tạo bảng ViTriCongViec
CREATE TABLE ViTriCongViec (
    vi_tri_id INT PRIMARY KEY IDENTITY(1,1),
    ma_vi_tri NVARCHAR(10) NOT NULL UNIQUE,
    ten_vi_tri NVARCHAR(100) NOT NULL,
    level NVARCHAR(20) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    deleted_at BIT DEFAULT 0
);

-- Tạo bảng NhanVien
CREATE TABLE NhanVien (
    nhan_vien_id INT PRIMARY KEY IDENTITY(1,1),
    ma_nhan_vien NVARCHAR(10) NOT NULL UNIQUE,
    ten_nhan_vien NVARCHAR(100) NOT NULL,
    email NVARCHAR(100) NOT NULL UNIQUE,
    sdt NVARCHAR(15) NOT NULL,
    vi_tri_id INT,
    nhan_vien_quan_ly_id INT,
    ma_account VARCHAR(50) NOT NULL,
    roles_id INT NOT NULL,
    FOREIGN KEY (vi_tri_id) REFERENCES ViTriCongViec(vi_tri_id),
    FOREIGN KEY (nhan_vien_quan_ly_id) REFERENCES NhanVien(nhan_vien_id),
    FOREIGN KEY (ma_account) REFERENCES Account(ma),
    FOREIGN KEY (roles_id) REFERENCES Roles(role_id),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ,
    deleted_at BIT DEFAULT 0
);

-- Tạo bảng DotTuyenDung
CREATE TABLE DotTuyenDung (
    dot_tuyen_dung_id INT PRIMARY KEY IDENTITY(1,1),
    ma_dot_tuyen_dung NVARCHAR(10) NOT NULL UNIQUE,
    ten_dot_tuyen_dung NVARCHAR(100) NOT NULL,
    noi_dung NVARCHAR(MAX) NOT NULL,
    deadline DATE NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES NhanVien(nhan_vien_id),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ,
    deleted_at BIT DEFAULT 0
);

-- Tạo bảng CV
CREATE TABLE CV (
    cv_id INT PRIMARY KEY IDENTITY(1,1),
	maHoSo VARCHAR(20),
    apply_datetime DATE  NULL,
    full_name NVARCHAR(100)  NULL,
    gender NVARCHAR(10)  NULL,
    email NVARCHAR(100)  NULL UNIQUE,
    tel NVARCHAR(15)  NULL,
    city NVARCHAR(100)  NULL,
    job_name NVARCHAR(100)  NULL,
    tong_nam_kinh_nghiem DECIMAL(5,2) NOT NULL,
    note NVARCHAR(MAX),
    link_cv NVARCHAR(255) NOT NULL,
    nguon_tuyen_dung NVARCHAR(20) ,
    trang_thai NVARCHAR(50)  NULL ,
    share BIT DEFAULT 0,
    hr_user_id INT,
    FOREIGN KEY (hr_user_id) REFERENCES NhanVien(nhan_vien_id),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ,
    deleted_at BIT DEFAULT 0
);

-- Tạo bảng Activity
CREATE TABLE Activity (
    activity_id INT PRIMARY KEY IDENTITY(1,1),
     activity_ma NVARCHAR(20),
    activity_type NVARCHAR(20),
    activity_note NVARCHAR(255),
    user_id INT,
    share BIT DEFAULT 0,
    create_date DATE NOT NULL,
    FOREIGN KEY (user_id) REFERENCES NhanVien(nhan_vien_id),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ,
    deleted_at BIT DEFAULT 0
);


-- Thêm dữ liệu mẫu vào bảng Roles
INSERT INTO Roles (ma, authority) VALUES
('HaiPham1', 'ROLE_ADMIN'),
('HaiPham2', 'ROLE_MANAGER'),
('HaiPham3', 'ROLE_MEMBER');

-- Thêm dữ liệu mẫu vào bảng Account
INSERT INTO Account (ma, username, email, passwords, enableds) VALUES
('HaiPham1', 'HaiPham1a', 'haipham1@example.com', '$2a$12$6eF5x.vDFF5ZJ5PSto1RreCCckFIKRtWPhTXfxezkEHbAK7Vu2KaG', 1),
('HaiPham2', 'HaiPham2a', 'haipham2@example.com', '$2a$12$4OD6G/0peAQniCtESBi8lOp3yDcjar1h68xS81GivPDEY6aAXr5JW', 1),
('HaiPham3', 'HaiPham3a', 'haipham3@example.com', '$2a$12$Kz9lCK7tyqKfOSPvyQemX.V98UP0ZBHpBftucdLsvOn/kWEQ9k/v6', 1);




-- Thêm dữ liệu mẫu vào bảng account_roles
INSERT INTO account_roles (account_id, role_id) VALUES
('HaiPham1', (SELECT role_id FROM Roles WHERE ma = 'HaiPham1')),
('HaiPham1', (SELECT role_id FROM Roles WHERE ma = 'HaiPham2')),
('HaiPham3', (SELECT role_id FROM Roles WHERE ma = 'HaiPham3'));




-- Thêm dữ liệu mẫu vào bảng PhongBan
INSERT INTO PhongBan (ma_phong_ban, ten_phong_ban) VALUES 
('PB001', N'Phòng Nhân Sự'),
('PB002', N'Phòng Kỹ Thuật'),
('PB003', N'Phòng Tài Chính'),
('PB004', N'Phòng Marketing'),
('PB005', N'Phòng Bán Hàng'),
('PB006', N'Phòng Hỗ Trợ Kỹ Thuật'),
('PB007', N'Phòng Sản Xuất'),
('PB008', N'Phòng Nghiên Cứu & Phát Triển'),
('PB009', N'Phòng Pháp Lý'),
('PB010', N'Phòng Quản Trị'),
('PB011', N'Phòng Đào Tạo'),
('PB012', N'Phòng Dịch Vụ Khách Hàng');


-- Thêm dữ liệu mẫu vào bảng ViTriCongViec
INSERT INTO ViTriCongViec (ma_vi_tri, ten_vi_tri, level) VALUES 
('VT001', N'Nhân viên Kỹ thuật', 'Junior'),
('VT002', N'Trưởng phòng Nhân sự', 'Manager'),
('VT003', N'Nhân viên Marketing', 'Senior'),
('VT004', N'Trưởng phòng Bán hàng', 'Manager'),
('VT005', N'Nhân viên Hỗ trợ kỹ thuật', 'Mid'),
('VT006', N'Giám đốc Sản xuất', 'Director'),
('VT007', N'Nhân viên Nghiên cứu & Phát triển', 'Senior'),
('VT008', N'Nhân viên Pháp lý', 'Junior'),
('VT009', N'Nhân viên Quản trị', 'Mid'),
('VT010', N'Nhân viên Đào tạo', 'Junior'),
('VT011', N'Chuyên viên Dịch vụ Khách hàng', 'Senior'),
('VT012', N'Giám đốc Tài chính', 'Director');

-- Thêm dữ liệu mẫu vào bảng NhanVien
INSERT INTO NhanVien (ma_nhan_vien, ten_nhan_vien, email, sdt, vi_tri_id, nhan_vien_quan_ly_id, ma_account, roles_id) VALUES 
('NV001', N'Phạm Ngọc Hải', 'a.nguyen@company.com', '0900000001', 1, 1, 'HaiPham1', 1), 
('NV002', N'Nguyễn Thị Thuý Hằng', 'b.tran@company.com', '0900000002', 2, 1, 'HaiPham2', 2), 
('NV003', N'Nguyễn Thảo Linh', 'c.le@company.com', '0900000003', 1, 1, 'HaiPham2', 3), 
('NV004', N'Phạm Thị D', 'd.pham@company.com', '0900000004', 2, 2, 'HaiPham3', 3), 
('NV005', N'Hoàng Văn E', 'e.hoang@company.com', '0900000005', 2, 2, 'HaiPham3', 3),
('NV006', N'Phạm Thị T', 'z.pham@company.com', '0900000004', 2, 2, 'HaiPham3', 3), 
('NV007', N'Hoàng Văn Z', 'k.hoang@company.com', '0900000005', 2, 2, 'HaiPham3', 3);

-- Thêm dữ liệu mẫu vào bảng DotTuyenDung
INSERT INTO DotTuyenDung (ma_dot_tuyen_dung, ten_dot_tuyen_dung, noi_dung, deadline, user_id) 
VALUES 
('DTD001', N'Đợt tuyển dụng tháng 1', N'Chi tiết tuyển dụng tháng 1', GETDATE(), 1), 
('DTD002', N'Đợt tuyển dụng tháng 2', N'Chi tiết tuyển dụng tháng 2', GETDATE(), 2), 
('DTD003', N'Đợt tuyển dụng tháng 3', N'Chi tiết tuyển dụng tháng 3',GETDATE(), 3), 
('DTD004', N'Đợt tuyển dụng tháng 4', N'Chi tiết tuyển dụng tháng 4', GETDATE(), 4), 
('DTD005', N'Đợt tuyển dụng tháng 5', N'Chi tiết tuyển dụng tháng 5', GETDATE(), 5), 
('DTD006', N'Đợt tuyển dụng tháng 6', N'Chi tiết tuyển dụng tháng 6', GETDATE(), 6), 
('DTD007', N'Đợt tuyển dụng tháng 7', N'Chi tiết tuyển dụng tháng 7', GETDATE(), 1), 
('DTD008', N'Đợt tuyển dụng tháng 8', N'Chi tiết tuyển dụng tháng 8', GETDATE(), 2), 
('DTD009', N'Đợt tuyển dụng tháng 9', N'Chi tiết tuyển dụng tháng 9', GETDATE(), 3), 
('DTD010', N'Đợt tuyển dụng tháng 10', N'Chi tiết tuyển dụng tháng 10', GETDATE(), 4), 
('DTD011', N'Đợt tuyển dụng tháng 11', N'Chi tiết tuyển dụng tháng 11', GETDATE(), 5), 
('DTD012', N'Đợt tuyển dụng tháng 12', N'Chi tiết tuyển dụng tháng 12', GETDATE(), 6);


-- Thêm dữ liệu mẫu vào bảng CV
INSERT INTO CV (maHoSo, apply_datetime, full_name, gender, email, tel, city, job_name, tong_nam_kinh_nghiem, note, link_cv, nguon_tuyen_dung, trang_thai, share, hr_user_id)
VALUES
('HS001', '2024-09-01', N'Nguyễn Văn A', N'Nam', 'nguyenvana@example.com', '0912345678', N'Hà Nội', N'Lập trình viên', 3.5, N'Có kinh nghiệm về Java', 'http://example.com/cv_nguyenvana', 'LinkedIn', N'Đậu Phỏng Vấn', 1, 1),
('HS002', '2024-09-02', N'Trần Thị B', N'Nữ', 'tranthib@example.com', '0987654321', N'Hồ Chí Minh', N'Kiểm thử', 2.0, N'Tốt nghiệp ngành CNTT', 'http://example.com/cv_tranthib', 'Referral', N'Chưa Phỏng', 0, 2),
('HS003', '2024-09-03', N'Lê Văn C', N'Nam', 'levanc@example.com', '0901234567', N'Đà Nẵng', N'Quản lý dự án', 7.0, N'Quản lý dự án phần mềm', 'http://example.com/cv_levanc', 'Facebook', N'Rớt Phỏng Vấn', 1, 3),
('HS004', '2024-09-04', N'Phạm Thị D', N'Nữ', 'phamthid@example.com', '0934567890', N'Cần Thơ', N'BA', 5.0, N'Kinh nghiệm BA 5 năm', 'http://example.com/cv_phamthid', 'TopCV', N'Cân Nhắc Sau', 0, 4),
('HS005', '2024-09-05', N'Đỗ Văn E', N'Nam', 'dovane@example.com', '0923456789', N'Hải Phòng', N'Nhà thiết kế', 4.0, N'Thiết kế đồ họa', 'http://example.com/cv_dovane', 'LinkedIn', N'Nghỉ Việc', 0, 5),
('HS006', '2024-09-06', N'Hoàng Thị F', N'Nữ', 'hoangthif@example.com', '0945678912', N'Quảng Ninh', N'Marketing', 1.5, N'Kinh nghiệm marketing', 'http://example.com/cv_hoangthif', 'Referral', N'Bị Thôi Việc', 1, 6),
('HS007', '2024-09-07', N'Võ Văn G', N'Nam', 'vovang@example.com', '0956789123', N'Huế', 'QA', 6.0, N'Kiểm thử phần mềm', 'http://example.com/cv_vovang', 'LinkedIn', N'Đậu Phỏng Vấn', 1, 7),
('HS008', '2024-09-08', N'Vũ Thị H', N'Nữ', 'vuthih@example.com', '0967891234', N'Đà Nẵng', 'HR', 4.5, N'Quản lý nhân sự', 'http://example.com/cv_vuthih', 'TopCV', N'Rớt Phỏng Vấn', 0, 1),
('HS009', '2024-09-09', N'Nguyễn Văn I', N'Nam', 'nguyenvani@example.com', '0978912345', N'Hà Nội', N'Lập trình viên', 2.0, N'Lập trình C#', 'http://example.com/cv_nguyenvani', 'LinkedIn', N'Cân Nhắc Sau', 1, 2),
('HS010', '2024-09-10', N'Trần Thị J', N'Nữ', 'tranthij@example.com', '0989123456', N'TP HCM', N'Kiểm thử', 3.0, N'Kiểm thử tự động', 'http://example.com/cv_tranthij', 'Referral', N'Chưa Phỏng', 0, 3),
('HS011', '2024-09-11', N'Lê Văn K', N'Nam', 'levank@example.com', '0991234567', N'Huế', 'BA', 2.5, N'Tư vấn nghiệp vụ', 'http://example.com/cv_levank', 'Facebook', N'Đậu Phỏng Vấn', 1, 4),
('HS012', '2024-09-12', N'Phạm Thị L',    N'Nữ', 'phamthil@example.com', '0909876543', N'Hà Nội', N'Marketing', 3.0, N'Digital marketing', 'http://example.com/cv_phamthil', 'LinkedIn', N'Nghỉ Việc', 1, 5);






-- Thêm dữ liệu mẫu vào bảng Activity
INSERT INTO Activity (activity_ma, activity_type, activity_note, user_id, share, create_date)
VALUES
('ACT001', N'Gọi điện', N'Liên hệ với khách hàng về phỏng vấn', 1, 1, GETDATE()),
('ACT002', N'Meeting', N'Cuộc họp với team tuyển dụng', 2, 0,  GETDATE()),
('ACT003', N'Chat Zalo', N'Nhắn tin với ứng viên qua Zalo', 1, 1,  GETDATE()),
('ACT004', N'Gọi điện', N'Gọi nhắc ứng viên về lịch phỏng vấn', 3, 0,  GETDATE()),
('ACT005', N'Meeting', N'Cuộc họp định kỳ hàng tuần', 4, 1,  GETDATE()),
('ACT006', N'Chat Zalo', N'Trao đổi thêm với ứng viên về chi tiết công việc', 2, 1,  GETDATE()),
('ACT007', N'Gọi điện', N'Liên hệ với ứng viên sau phỏng vấn', 3, 0,  GETDATE()),
('ACT008', N'Meeting', N'Cuộc họp đánh giá kết quả phỏng vấn', 1, 1,  GETDATE()),
('ACT009', N'Chat Zalo', N'Nhắn tin Zalo về feedback phỏng vấn', 4, 0,  GETDATE()),
('ACT010', N'Gọi điện', N'Gọi điện về kết quả phỏng vấn', 1, 1, GETDATE()),
('ACT011', N'Meeting', N'Buổi họp kế hoạch tuyển dụng', 2, 0,  GETDATE()),
('ACT012', N'Chat Zalo', N'Nhắn tin với ứng viên để xác nhận offer', 3, 1,  GETDATE());



SELECT*FROM NhanVien
SELECT*FROM PhongBan
SELECT*FROM ViTriCongViec
SELECT*FROM DotTuyenDung
SELECT*FROM CV
SELECT*FROM Activity
UPDATE NhanVien set deleted_at=0