USE [LINHKIENMAYTINH]
GO
/****** Object:  Table [dbo].[CASE]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CASE](
	[maSanPham] [nchar](20) NOT NULL,
	[chatLieu] [nvarchar](20) NULL,
	[mau] [nvarchar](20) NULL,
	[tuongThich] [nvarchar](20) NULL,
 CONSTRAINT [PK_CASE] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[soLuongMua] [int] NULL,
	[maSanPham] [nchar](20) NOT NULL,
	[maHoaDon] [nchar](20) NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC,
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ConNguoi]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ConNguoi](
	[ma] [nchar](20) NOT NULL,
	[ten] [nvarchar](50) NULL,
	[sdt] [nchar](15) NULL,
	[gioiTinh] [bit] NULL,
	[email] [nchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[loai] [nvarchar](20) NULL,
 CONSTRAINT [PK_ConNguoi] PRIMARY KEY CLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CPU]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CPU](
	[maSanPham] [nchar](20) NOT NULL,
	[soLoi] [int] NULL,
	[soLuong] [int] NULL,
	[tanSoCoSo] [float] NULL,
	[tanSoTurbo] [float] NULL,
	[boNhoDem] [int] NULL,
	[boNhoToiDa] [int] NULL,
 CONSTRAINT [PK_CPU] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nchar](20) NOT NULL,
	[ngayLapHoaDon] [date] NULL,
	[tienKhachTra] [float] NULL,
	[hinhThucThanhToan] [nvarchar](50) NULL,
	[ghiChu] [nvarchar](50) NULL,
	[thueVAT] [float] NULL,
	[maKhachHang] [nchar](20) NULL,
	[maNhanVien] [nchar](20) NULL,
	[giamGia] [float] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[ma] [nchar](20) NOT NULL,
	[diemTichLuy] [float] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MAIN]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAIN](
	[maSanPham] [nchar](20) NOT NULL,
	[chipSet] [nvarchar](50) NULL,
	[ramHoTro] [nvarchar](50) NULL,
	[cpuHoTro] [nvarchar](50) NULL,
	[doHoa] [nvarchar](50) NULL,
	[oCungHoTro] [nvarchar](50) NULL,
 CONSTRAINT [PK_MAIN] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[ma] [nchar](20) NOT NULL,
	[chucVu] [nvarchar](50) NULL,
	[cmnd] [nchar](20) NULL,
	[matKhau] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PSU]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PSU](
	[maSanPham] [nchar](20) NOT NULL,
	[congSuat] [int] NULL,
	[hieuSuat] [int] NULL,
	[tuoiTho] [int] NULL,
 CONSTRAINT [PK_PSU] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RAM]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RAM](
	[maSanPham] [nchar](20) NOT NULL,
	[dungLuong] [int] NULL,
	[tocDo] [int] NULL,
 CONSTRAINT [PK_RAM] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSanPham] [nchar](20) NOT NULL,
	[tenSanPham] [nvarchar](50) NULL,
	[giaBan] [float] NULL,
	[soLuongTonKho] [int] NULL,
	[nhaSanXuat] [nvarchar](50) NULL,
	[ngaySanXuat] [date] NULL,
	[baoHanh] [int] NULL,
	[giaNhap] [float] NULL,
	[giamGia] [int] NULL,
	[loaiSanPham] [nchar](10) NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VGA]    Script Date: 5/4/2023 8:29:07 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VGA](
	[maSanPham] [nchar](20) NOT NULL,
	[tienTrinh] [int] NULL,
	[TDP] [int] NULL,
	[cudaCores] [int] NULL,
 CONSTRAINT [PK_VGA] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CASE] ([maSanPham], [chatLieu], [mau], [tuongThich]) VALUES (N'SP1                 ', N'Thép', N'Đen', N'
44 x 21.2 x 43 cm')
INSERT [dbo].[CASE] ([maSanPham], [chatLieu], [mau], [tuongThich]) VALUES (N'SP3                 ', N'Thép, nhựa', N'Đen', N'
440 mm x 180 mm')
INSERT [dbo].[CASE] ([maSanPham], [chatLieu], [mau], [tuongThich]) VALUES (N'SP4                 ', N'Thép, kính', N'Đen', N'
373 x 182 x 420 mm')
INSERT [dbo].[CASE] ([maSanPham], [chatLieu], [mau], [tuongThich]) VALUES (N'SP5                 ', N'Thép', N'Đen', N'
44.3 x 48.4 x 21')
INSERT [dbo].[CASE] ([maSanPham], [chatLieu], [mau], [tuongThich]) VALUES (N'SP6                 ', N'Thép', N'Trắng', N'348 x 280 x 378 mm')
INSERT [dbo].[CASE] ([maSanPham], [chatLieu], [mau], [tuongThich]) VALUES (N'SP7                 ', N'Thép', N'Đen', N'
474 x 231 x 490 mm')
INSERT [dbo].[CASE] ([maSanPham], [chatLieu], [mau], [tuongThich]) VALUES (N'SP8                 ', N'Thép', N'Đen', N'205 x 350 x 460 mm')
INSERT [dbo].[CASE] ([maSanPham], [chatLieu], [mau], [tuongThich]) VALUES (N'SP9                 ', N'Thép', N'Trắng', N'
20.5 x 35 x 46 cm')
GO
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP1                 ', N'HD1                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (2, N'SP1                 ', N'HD3                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (10, N'SP1                 ', N'HD5                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP11                ', N'HD1                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (2, N'SP11                ', N'HD7                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP16                ', N'HD13                ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP16                ', N'HD6                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP21                ', N'HD10                ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP21                ', N'HD2                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP21                ', N'HD9                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP22                ', N'HD5                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP26                ', N'HD14                ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (6, N'SP3                 ', N'HD3                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (5, N'SP3                 ', N'HD4                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP30                ', N'HD12                ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP34                ', N'HD8                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP4                 ', N'HD2                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (2, N'SP47                ', N'HD16                ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP51                ', N'HD1                 ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP51                ', N'HD18                ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (2, N'SP52                ', N'HD17                ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP53                ', N'HD11                ')
INSERT [dbo].[ChiTietHoaDon] ([soLuongMua], [maSanPham], [maHoaDon]) VALUES (1, N'SP7                 ', N'HD15                ')
GO
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH0                 ', N'Khách Hàng Lẻ', N'rỗng           ', 0, N'rỗng                                              ', N'rỗng', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH1                 ', N'Nguyễn Thị A', N'0985442697     ', 0, N'vidu@gmail.com                                    ', N'Tân Phú', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH10                ', N'Khách Hàng Lẻ', N'rỗng           ', 0, N'rỗng                                              ', N'rỗng', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH11                ', N'Nguyễn Kiều Hương', N'0747333842     ', 0, N'huong@gmail.com                                   ', N'Gò Vấp', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH12                ', N'Đỗ Thị Loan', N'0983271690     ', 0, N'loan@gmail.com                                    ', N'Quận 7', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH13                ', N'Võ Xuân Sang', N'0377988246     ', 1, N'sang@gmail.com                                    ', N'Gò Vấp', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH2                 ', N'Văn B', N'0374845876     ', 1, N'vidu1@gmail.com                                   ', N'Bình Chánh', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH3                 ', N'Vũ Văn C', N'0986652864     ', 1, N'vidu2@gmail.com                                   ', N'Quận 2', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH4                 ', N'Bùi Thị C', N'0976349871     ', 0, N'vidu4@gmail.com                                   ', N'Quận 7', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH5                 ', N'Trần Văn Bình', N'0373269143     ', 1, N'binh@gmail.com                                    ', N'Bình Thạnh', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH6                 ', N'Nguyễn Thị Hông Thắm', N'0349256721     ', 0, N'tham@gmail.com                                    ', N'Bình Thạnh', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH7                 ', N'Lê Tấn Phát', N'0706254888     ', 1, N'phat@gmail.com                                    ', N'Tân Bình', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH8                 ', N'Bùi Viết Xuân', N'0352761124     ', 1, N'xuan@gmail.com                                    ', N'Quận 12', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'KH9                 ', N'Trương Thị Liễu', N'0375441269     ', 0, N'lieu@gmail.com                                    ', N'Quận 5', N'KhachHang')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'NV1                 ', N'Huỳnh Quốc Bảo', N'0353426938     ', 1, N'hbao27121@gmail.com                               ', N'614/10 Tô Ký, Phường Tân Chánh Hiệp, Q12, TPHCM', N'NhanVien')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'NV2                 ', N'Võ Mạnh Hiếu', N'0123456789     ', 1, N'hieu@gmail.com                                    ', N'Gò Vấp', N'NhanVien')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'NV3                 ', N'Nguyễn Trọng Đạt', N'0987654321     ', 1, N'dat@gmail.com                                     ', N'Tân Bình', N'NhanVien')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'NV4                 ', N'Hồ Vĩnh Duy', N'099887766      ', 1, N'duy@gmail.com                                     ', N'Quận 12', N'NhanVien')
INSERT [dbo].[ConNguoi] ([ma], [ten], [sdt], [gioiTinh], [email], [diaChi], [loai]) VALUES (N'NV5                 ', N'Trần Thị Anh Thi', N'098765423      ', 0, N'cothi@gmail.com                                   ', N'Quận 1', N'NhanVien')
GO
INSERT [dbo].[CPU] ([maSanPham], [soLoi], [soLuong], [tanSoCoSo], [tanSoTurbo], [boNhoDem], [boNhoToiDa]) VALUES (N'SP11                ', 24, 32, 6, 6, 36, 128)
INSERT [dbo].[CPU] ([maSanPham], [soLoi], [soLuong], [tanSoCoSo], [tanSoTurbo], [boNhoDem], [boNhoToiDa]) VALUES (N'SP12                ', 24, 32, 6, 6, 36, 128)
INSERT [dbo].[CPU] ([maSanPham], [soLoi], [soLuong], [tanSoCoSo], [tanSoTurbo], [boNhoDem], [boNhoToiDa]) VALUES (N'SP13                ', 24, 32, 5.8, 4.3, 36, 128)
INSERT [dbo].[CPU] ([maSanPham], [soLoi], [soLuong], [tanSoCoSo], [tanSoTurbo], [boNhoDem], [boNhoToiDa]) VALUES (N'SP14                ', 24, 32, 5.8, 4.3, 36, 128)
INSERT [dbo].[CPU] ([maSanPham], [soLoi], [soLuong], [tanSoCoSo], [tanSoTurbo], [boNhoDem], [boNhoToiDa]) VALUES (N'SP15                ', 10, 20, 5.8, 4.3, 19, 256)
INSERT [dbo].[CPU] ([maSanPham], [soLoi], [soLuong], [tanSoCoSo], [tanSoTurbo], [boNhoDem], [boNhoToiDa]) VALUES (N'SP16                ', 16, 24, 5.3, 3.4, 30, 128)
INSERT [dbo].[CPU] ([maSanPham], [soLoi], [soLuong], [tanSoCoSo], [tanSoTurbo], [boNhoDem], [boNhoToiDa]) VALUES (N'SP17                ', 4, 8, 4.5, 3.4, 12, 128)
INSERT [dbo].[CPU] ([maSanPham], [soLoi], [soLuong], [tanSoCoSo], [tanSoTurbo], [boNhoDem], [boNhoToiDa]) VALUES (N'SP18                ', 16, 32, 5.7, 4.2, 32, 258)
INSERT [dbo].[CPU] ([maSanPham], [soLoi], [soLuong], [tanSoCoSo], [tanSoTurbo], [boNhoDem], [boNhoToiDa]) VALUES (N'SP19                ', 18, 36, 3, 4.7, 32, 258)
INSERT [dbo].[CPU] ([maSanPham], [soLoi], [soLuong], [tanSoCoSo], [tanSoTurbo], [boNhoDem], [boNhoToiDa]) VALUES (N'SP20                ', 18, 36, 3.9, 4.7, 64, 512)
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD1                 ', CAST(N'2023-01-23' AS Date), 11450000, N'Tiền mặt', N'Trống', 0.1, N'KH1                 ', N'NV4                 ', 100000)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD10                ', CAST(N'2022-05-03' AS Date), 6740000, N'Quẹt thẻ', N'Trống', 0.1, N'KH5                 ', N'NV2                 ', 300000)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD11                ', CAST(N'2021-02-03' AS Date), 4300000, N'Tiền mặt', N'Trống', 0.1, N'KH6                 ', N'NV2                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD12                ', CAST(N'2023-05-03' AS Date), 9130000, N'Tiền mặt', N'Trống', 0.1, N'KH7                 ', N'NV3                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD13                ', CAST(N'2023-06-04' AS Date), 11880000, N'Quẹt thẻ', N'Trống', 0.2, N'KH8                 ', N'NV3                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD14                ', CAST(N'2023-07-04' AS Date), 9130000, N'Chuyển khoản', N'Trống', 0.2, N'KH9                 ', N'NV3                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD15                ', CAST(N'2022-03-04' AS Date), 3600000, N'Tiền mặt', N'Trống', 0.1, N'KH10                ', N'NV3                 ', 250000)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD16                ', CAST(N'2021-06-04' AS Date), 6820000, N'Tiền mặt', N'Trống', 0.1, N'KH11                ', N'NV2                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD17                ', CAST(N'2021-08-04' AS Date), 6380000, N'Chuyển khoản', N'Trống', 0.1, N'KH12                ', N'NV2                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD18                ', CAST(N'2022-11-04' AS Date), 2000000, N'Tiền mặt', N'Trống', 0.1, N'KH13                ', N'NV2                 ', 100000)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD2                 ', CAST(N'2023-06-23' AS Date), 7645000, N'Quẹt thẻ', N'Trống', 0.1, N'KH4                 ', N'NV1                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD3                 ', CAST(N'2022-12-23' AS Date), 6000000, N'Tiền mặt', N'Trống', 0.1, N'KH0                 ', N'NV1                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD4                 ', CAST(N'2022-04-28' AS Date), 4000000, N'Tiền mặt', N'Trống', 0.1, N'KH0                 ', N'NV1                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD5                 ', CAST(N'2021-04-28' AS Date), 20000000, N'Tiền mặt', N'Trống', 0.1, N'KH1                 ', N'NV1                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD6                 ', CAST(N'2023-04-29' AS Date), 12000000, N'Tiền mặt', N'Trống', 0.2, N'KH2                 ', N'NV2                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD7                 ', CAST(N'2023-04-30' AS Date), 16950000, N'Quẹt thẻ', N'Trống', 0.2, N'KH3                 ', N'NV2                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD8                 ', CAST(N'2022-05-01' AS Date), 4300000, N'Chuyển khoản', N'Trống', 0.1, N'KH4                 ', N'NV2                 ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [tienKhachTra], [hinhThucThanhToan], [ghiChu], [thueVAT], [maKhachHang], [maNhanVien], [giamGia]) VALUES (N'HD9                 ', CAST(N'2023-05-02' AS Date), 7200000, N'Chuyển khoản', N'Trống', 0.1, N'KH3                 ', N'NV1                 ', 0)
GO
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH0                 ', 0)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH1                 ', 1300)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH10                ', 2500)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH11                ', 1800)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH12                ', 1000)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH13                ', 1400)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH2                 ', 2000)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH3                 ', 3000)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH4                 ', 1300)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH5                 ', 3000)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH6                 ', 5000)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH7                 ', 1500)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH8                 ', 2100)
INSERT [dbo].[KhachHang] ([ma], [diemTichLuy]) VALUES (N'KH9                 ', 3200)
GO
INSERT [dbo].[MAIN] ([maSanPham], [chipSet], [ramHoTro], [cpuHoTro], [doHoa], [oCungHoTro]) VALUES (N'SP21                ', N'AMD B650', N'hỗ trợ bộ nhớ 128 GB', N'AMD Socket AM5, hỗ trợ: Bộ xử lý AMD Ryzen 7000', N'hỗ trợ độ phân giải tối đa 3840x2160 - 144 Hz', N'DDR5 6600(OC) / 6400(OC) / 6200(OC) / 6000(OC)')
INSERT [dbo].[MAIN] ([maSanPham], [chipSet], [ramHoTro], [cpuHoTro], [doHoa], [oCungHoTro]) VALUES (N'SP22                ', N'AMD B650', N'Dung lượng tối đa: 128GB', N'Bộ vi xử lý dòng AMD Socket AM5 Ryzen 7000', N'Hỗ trợ HDCP: tối đa độ phân giải 4K 60Hz.', N'Hỗ trợ EXTended Profiles for Overclocking (EXPO)')
INSERT [dbo].[MAIN] ([maSanPham], [chipSet], [ramHoTro], [cpuHoTro], [doHoa], [oCungHoTro]) VALUES (N'SP23                ', N'AMD B650', N'Dung lượng tối đa: 128GB', N'AMD Socket AM5, hỗ trợ cho: AMD Ryzen 7000', N'1 x DisplayPort, hỗ trợ độ phân giải 3840x2160', N'DDR5 6400(OC) / 6200(OC) / 6000(OC) / 5600(OC)')
INSERT [dbo].[MAIN] ([maSanPham], [chipSet], [ramHoTro], [cpuHoTro], [doHoa], [oCungHoTro]) VALUES (N'SP24                ', N'AMD B650', N'Dung lượng tối đa: 128GB', N'AMD Socket AM5 dành cho Bộ xử lý máy tính để bàn', N'1 x DisplayPort, hỗ trợ độ phân giải 3840x2160', N'6200(OC)/ 6000(OC)/ 5800(OC)/ 5600/ 5400/ 4800 ECC')
INSERT [dbo].[MAIN] ([maSanPham], [chipSet], [ramHoTro], [cpuHoTro], [doHoa], [oCungHoTro]) VALUES (N'SP25                ', N'Intel B650 Chipset', N'Dung lượng tối đa: 128GB', N'Hỗ trợ bộ vi xử lý AMD Ryzen™ 7000 Series', N'Hỗ trợ HDMITM 2.1 với HDR, độ phân giải 4K 60Hz*', N'6200(OC)/ 6000(OC)/ 5800(OC)/ 5600/ 5400/ 4800 ECC')
INSERT [dbo].[MAIN] ([maSanPham], [chipSet], [ramHoTro], [cpuHoTro], [doHoa], [oCungHoTro]) VALUES (N'SP26                ', N'AMD B650', N'Dung lượng tối đa: 128GB', N'AMD Socket AM5 dành cho Bộ xử lý máy tính để bàn ', N'Hỗ trợ HDMITM 2.1 với HDR, độ phân giải 4K 60Hz*', N'DDR5 6400+ (OC) / 6200 (OC) / 6000 (OC)')
INSERT [dbo].[MAIN] ([maSanPham], [chipSet], [ramHoTro], [cpuHoTro], [doHoa], [oCungHoTro]) VALUES (N'SP27                ', N'Intel B660', N'4 x DIMM, Tối đa 128GB', N'Intel LGA 1700', N'Hỗ trợ 4K@60Hz như được chỉ định trong HDMI 2.1.', N'Hỗ trợ 2 khe cắm M.2 x và 4 cổng SATA 6Gb / s')
INSERT [dbo].[MAIN] ([maSanPham], [chipSet], [ramHoTro], [cpuHoTro], [doHoa], [oCungHoTro]) VALUES (N'SP28                ', N'Intel', N'4 x DIMM, Tối đa 128GB', N'Intel Z790', N'Hỗ trợ 4K@60Hz như được chỉ định trong HDMI 2.1.', N'Tổng cộng hỗ trợ 5 khe cắm M.2 và 6 x cổng SATA')
INSERT [dbo].[MAIN] ([maSanPham], [chipSet], [ramHoTro], [cpuHoTro], [doHoa], [oCungHoTro]) VALUES (N'SP29                ', N'Intel', N'2 x DIMM, Tối đa 64GB', N'Intel Z790', N'1 x cổng HDMI', N'Tổng cộng hỗ trợ 5 khe cắm M.2 và 6 x cổng SATA')
INSERT [dbo].[MAIN] ([maSanPham], [chipSet], [ramHoTro], [cpuHoTro], [doHoa], [oCungHoTro]) VALUES (N'SP30                ', N'Intel', N'2 x DIMM, Tối đa 64GB', N'Intel Z790', N'1 x cổng HDMI', N'Tổng cộng hỗ trợ 5 khe cắm M.2 và 6 x cổng SATA')
GO
INSERT [dbo].[NhanVien] ([ma], [chucVu], [cmnd], [matKhau]) VALUES (N'NV1                 ', N'Nhân viên', N'212856027           ', N'123456')
INSERT [dbo].[NhanVien] ([ma], [chucVu], [cmnd], [matKhau]) VALUES (N'NV2                 ', N'Nhân viên', N'123456789           ', N'123456')
INSERT [dbo].[NhanVien] ([ma], [chucVu], [cmnd], [matKhau]) VALUES (N'NV3                 ', N'Nhân viên', N'123456789           ', N'123456')
INSERT [dbo].[NhanVien] ([ma], [chucVu], [cmnd], [matKhau]) VALUES (N'NV4                 ', N'Nhân viên', N'123455678           ', N'123456')
INSERT [dbo].[NhanVien] ([ma], [chucVu], [cmnd], [matKhau]) VALUES (N'NV5                 ', N'Quản lý', N'123455678           ', N'123456')
GO
INSERT [dbo].[PSU] ([maSanPham], [congSuat], [hieuSuat], [tuoiTho]) VALUES (N'SP31                ', 650, 80, 5)
INSERT [dbo].[PSU] ([maSanPham], [congSuat], [hieuSuat], [tuoiTho]) VALUES (N'SP32                ', 750, 85, 7)
INSERT [dbo].[PSU] ([maSanPham], [congSuat], [hieuSuat], [tuoiTho]) VALUES (N'SP33                ', 850, 90, 10)
INSERT [dbo].[PSU] ([maSanPham], [congSuat], [hieuSuat], [tuoiTho]) VALUES (N'SP34                ', 1000, 95, 12)
INSERT [dbo].[PSU] ([maSanPham], [congSuat], [hieuSuat], [tuoiTho]) VALUES (N'SP35                ', 550, 75, 3)
INSERT [dbo].[PSU] ([maSanPham], [congSuat], [hieuSuat], [tuoiTho]) VALUES (N'SP36                ', 1200, 98, 15)
INSERT [dbo].[PSU] ([maSanPham], [congSuat], [hieuSuat], [tuoiTho]) VALUES (N'SP37                ', 950, 92, 8)
INSERT [dbo].[PSU] ([maSanPham], [congSuat], [hieuSuat], [tuoiTho]) VALUES (N'SP38                ', 800, 88, 6)
INSERT [dbo].[PSU] ([maSanPham], [congSuat], [hieuSuat], [tuoiTho]) VALUES (N'SP39                ', 1300, 99, 20)
INSERT [dbo].[PSU] ([maSanPham], [congSuat], [hieuSuat], [tuoiTho]) VALUES (N'SP40                ', 700, 82, 4)
GO
INSERT [dbo].[RAM] ([maSanPham], [dungLuong], [tocDo]) VALUES (N'SP51                ', 16, 100)
INSERT [dbo].[RAM] ([maSanPham], [dungLuong], [tocDo]) VALUES (N'SP52                ', 32, 900)
INSERT [dbo].[RAM] ([maSanPham], [dungLuong], [tocDo]) VALUES (N'SP53                ', 32, 800)
INSERT [dbo].[RAM] ([maSanPham], [dungLuong], [tocDo]) VALUES (N'SP54                ', 32, 700)
INSERT [dbo].[RAM] ([maSanPham], [dungLuong], [tocDo]) VALUES (N'SP55                ', 32, 600)
INSERT [dbo].[RAM] ([maSanPham], [dungLuong], [tocDo]) VALUES (N'SP56                ', 16, 500)
INSERT [dbo].[RAM] ([maSanPham], [dungLuong], [tocDo]) VALUES (N'SP57                ', 32, 400)
INSERT [dbo].[RAM] ([maSanPham], [dungLuong], [tocDo]) VALUES (N'SP58                ', 16, 300)
INSERT [dbo].[RAM] ([maSanPham], [dungLuong], [tocDo]) VALUES (N'SP59                ', 16, 200)
INSERT [dbo].[RAM] ([maSanPham], [dungLuong], [tocDo]) VALUES (N'SP60                ', 32, 100)
GO
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP1                 ', N'Case máy tính Sama Shadow', 1000000, 5, N'ACER', CAST(N'2003-08-16' AS Date), 12, 800000, 100000, N'CASE      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP10                ', N'Thùng máy/ Case MSI MPG VELOX 100P AIRFLOW', 3600000, 16, N'HP', CAST(N'2007-12-10' AS Date), 12, 3400000, 100000, N'CASE      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP11                ', N'Intel Xeon E-2236 12MB 3.4GHz', 7800000, 8, N'MSI', CAST(N'2017-02-11' AS Date), 24, 7100000, 100000, N'CPU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP12                ', N'Intel Core i9 13900KS', 18000000, 5, N'DELL', CAST(N'2012-08-22' AS Date), 36, 17000000, 200000, N'CPU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP13                ', N'Intel Core i9 13900KF', 15500000, 11, N'HP', CAST(N'2018-11-12' AS Date), 36, 11000000, 200000, N'CPU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP14                ', N'Intel Core i9 13900K ', 16000000, 14, N'ASUS', CAST(N'2018-12-30' AS Date), 36, 15000000, 200000, N'CPU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP15                ', N'Intel Core i9 10900X', 15000000, 17, N'GIGABYTE', CAST(N'2016-12-30' AS Date), 36, 14000000, 200000, N'CPU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP16                ', N'Intel Core i7 13700KF', 11000000, 9, N'GIGABYTE', CAST(N'2007-12-30' AS Date), 36, 10500000, 200000, N'CPU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP17                ', N'Intel Core i3 13100F', 3100000, 9, N'DELL', CAST(N'2011-12-30' AS Date), 36, 2500000, 100000, N'CPU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP18                ', N'AMD Ryzen 9 7950X3D', 18500000, 12, N'HP', CAST(N'2019-12-30' AS Date), 36, 17500000, 200000, N'CPU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP19                ', N'Intel Core i9 10980XE', 27000000, 7, N'ASUS', CAST(N'2020-12-30' AS Date), 36, 22000000, 300000, N'CPU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP20                ', N'AMD Ryzen Threadripper Pro 3955WX', 31000000, 5, N'GIGABYTE', CAST(N'2021-12-15' AS Date), 36, 26000000, 300000, N'CPU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP21                ', N'GIGABYTE B650M AORUS ELITE AX (DDR5)', 6500000, 10, N'GIGABYTE', CAST(N'2023-08-16' AS Date), 24, 5500000, 100000, N'MAIN      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP22                ', N'NZXT N7 B650E WHITE', 9000000, 14, N'GIGABYTE', CAST(N'2011-08-20' AS Date), 24, 8000000, 100000, N'MAIN      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP23                ', N'GIGABYTE B650I AORUS ULTRA', 8900000, 7, N'GIGABYTE', CAST(N'2015-09-20' AS Date), 24, 8000000, 100000, N'MAIN      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP24                ', N'ASUS TUF GAMING B650M-PLUS WIFI (DDR5)', 6700000, 9, N'ASUS', CAST(N'2012-11-20' AS Date), 24, 5700000, 100000, N'MAIN      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP25                ', N'MSI MAG B650M MORTAR WIFI (DDR5)', 7200000, 9, N'MSI', CAST(N'2009-11-14' AS Date), 24, 6200000, 100000, N'MAIN      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP26                ', N'HP ROG STRIX B650-A GAMING WIFI', 8400000, 6, N'MSI', CAST(N'2015-11-14' AS Date), 24, 7400000, 100000, N'MAIN      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP27                ', N' Asus Prime B660M-A D4-CSM DDR4', 2900000, 9, N'ASUS', CAST(N'2015-11-14' AS Date), 24, 2000000, 100000, N'MAIN      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP28                ', N'ROG Maximus Z790 HERO Wifi D5', 16000000, 5, N'HP', CAST(N'2020-11-14' AS Date), 24, 15000000, 300000, N'MAIN      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP29                ', N'ASUS ROG Strix Z790-I Gaming Wifi D5', 12000000, 3, N'ASUS', CAST(N'2021-11-14' AS Date), 24, 10500000, 300000, N'MAIN      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP3                 ', N'Case máy tính Jetek G9311B - Mid Tower (Đen)', 700000, 9, N'DELL', CAST(N'2005-01-16' AS Date), 12, 550000, 100000, N'CASE      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP30                ', N'Mainboard Gigabyte Z690I A ULTRA DDR4', 8500000, 10, N'GIGAPYTE', CAST(N'2011-11-14' AS Date), 24, 7500000, 200000, N'MAIN      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP31                ', N'Corsair CX750M', 2190000, 28, N'DELL', CAST(N'2022-01-12' AS Date), 36, 1890000, 100000, N'PSU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP32                ', N'EVGA Supernova 850 G3', 3290000, 25, N'DELL', CAST(N'2021-10-05' AS Date), 60, 2790000, 100000, N'PSU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP33                ', N'Seasonic Focus Plus 750W', 2790000, 20, N'ASUS', CAST(N'2021-08-23' AS Date), 84, 2290000, 100000, N'PSU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP34                ', N'Thermaltake Toughpower GF1 850W', 3990000, 15, N'HP', CAST(N'2022-02-18' AS Date), 72, 3390000, 100000, N'PSU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP35                ', N'be quiet! Pure Power 11 600W', 1890000, 40, N'DELL', CAST(N'2021-11-30' AS Date), 60, 1590000, 100000, N'PSU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP36                ', N'SilverStone Strider Gold S 850W', 3690000, 10, N'HP', CAST(N'2022-04-02' AS Date), 84, 3190000, 100000, N'PSU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP37                ', N'Cooler Master MWE 750W Gold', 2390000, 34, N'MSI', CAST(N'2021-09-15' AS Date), 60, 1990000, 100000, N'PSU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP38                ', N'FSP Hydro G Pro 850W', 2990000, 20, N'MSI', CAST(N'2022-03-10' AS Date), 60, 2590000, 100000, N'PSU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP39                ', N'Gigabyte P850GM', 2590000, 30, N'GIGABYTE', CAST(N'2021-12-22' AS Date), 60, 2190000, 100000, N'PSU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP4                 ', N'Case máy tính Golden Field H3B - Mid Tower (Đen)', 650000, 5, N'DELL', CAST(N'2006-01-16' AS Date), 12, 450000, 100000, N'CASE      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP40                ', N'SeaSonic Prime TX-1000', 7690000, 5, N'ACER', CAST(N'2022-01-07' AS Date), 120, 6590000, 100000, N'PSU       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP41                ', N'Card màn hình MSI GeForce GTX 1050Ti', 1000000, 4, N'MSI', CAST(N'2022-07-17' AS Date), 12, 800000, 100000, N'VGA       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP42                ', N'Card màn hình DELL GeForce RTX 3060', 2000000, 3, N'DELL', CAST(N'2023-01-24' AS Date), 12, 1500000, 100000, N'VGA       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP43                ', N'Card màn hình ACER ROG STRIX ', 2500000, 1, N'ACER', CAST(N'2020-04-25' AS Date), 12, 1800000, 100000, N'VGA       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP44                ', N'Card màn hình HP GTX1050Ti STORMX', 1600000, 5, N'HP', CAST(N'2019-09-15' AS Date), 12, 1200000, 100000, N'VGA       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP45                ', N'Card màn hình HP RTX 4070', 1700000, 4, N'HP', CAST(N'2021-03-27' AS Date), 12, 1400000, 100000, N'VGA       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP46                ', N'Card màn hình DELL Inno3D 4GB', 3000000, 7, N'DELL', CAST(N'2023-02-26' AS Date), 12, 2500000, 100000, N'VGA       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP47                ', N'Card màn hình GIGABYTE GeForce', 3200000, 8, N'GIGABYTE', CAST(N'2022-08-25' AS Date), 12, 1700000, 100000, N'VGA       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP48                ', N'Card màn hình HP GeForce RTX', 2800000, 6, N'HP', CAST(N'2020-01-18' AS Date), 12, 2500000, 100000, N'VGA       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'sp49                ', N'Card màn hình MSI GeForce GTX 1650 D6', 2400000, 4, N'MSI', CAST(N'2021-09-12' AS Date), 12, 1700000, 100000, N'VGA       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP5                 ', N'Thùng máy/ Case Antec DP501- Tempered Glass', 1200000, 5, N'GIGABYTE', CAST(N'2006-02-21' AS Date), 12, 1000000, 100000, N'CASE      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP50                ', N'Card màn hình ACER ROG STRIX ', 2100000, 3, N'ACER', CAST(N'2022-03-20' AS Date), 12, 1600000, 100000, N'VGA       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP51                ', N'Bộ nhớ RAM TEAMGROUP T-Force Dark', 2000000, 7, N'ASUS', CAST(N'2019-02-21' AS Date), 12, 1700000, 100000, N'RAM       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP52                ', N'RAM GSkill Trident Z RGB 32GB (2x16GB)', 3000000, 20, N'ASUS', CAST(N'2019-02-19' AS Date), 12, 2500000, 100000, N'RAM       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP53                ', N'RAM GSkill Trident Z NEO RGB 32GB ', 4000000, 9, N'DELL', CAST(N'2003-12-12' AS Date), 12, 3400000, 100000, N'RAM       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP54                ', N'RAM DDR5 CORSAIR VENGEANCE RGB 32G/5200', 4200000, 6, N'DELL', CAST(N'2003-12-12' AS Date), 12, 4000000, 100000, N'RAM       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP55                ', N'Ram Kingston Fury Beast RGB 64GB (2x32GB) ', 3900000, 1, N'HP', CAST(N'2003-12-12' AS Date), 12, 3400000, 100000, N'RAM       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP56                ', N'RAM SAMSUNG 16GB DDR4 2666MHz', 2500000, 10, N'HP', CAST(N'2003-12-12' AS Date), 12, 2000000, 100000, N'RAM       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP57                ', N'RAM SAMSUNG 32GB DDR4 2666MHz', 4600000, 30, N'MSI', CAST(N'2003-12-12' AS Date), 12, 4000000, 100000, N'RAM       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP58                ', N'RAM Corsair Vengeance LPX 16GB (2x8GB)', 1800000, 32, N'ACER', CAST(N'2003-12-12' AS Date), 12, 1200000, 100000, N'RAM       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP59                ', N'RAM Gskill Trident Z5 32GB (2x16GB)', 2500000, 4, N'GIGABYTE', CAST(N'2003-12-12' AS Date), 12, 2000000, 100000, N'RAM       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP6                 ', N'Thùng máy/ Case Xigmatek Aqua M Arctic (EN40108)', 1400000, 7, N'GIGABYTE', CAST(N'2008-02-21' AS Date), 12, 1200000, 100000, N'CASE      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP60                ', N'Bộ Nhớ Ram Gskill Trident Z5 32GB', 4220000, 10, N'GIGABYTE', CAST(N'2003-12-12' AS Date), 12, 3600000, 100000, N'RAM       ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP7                 ', N'Thùng máy/ Case MSI MPG VELOX 100P AIRFLOW', 3600000, 9, N'ASUS', CAST(N'2012-02-21' AS Date), 12, 3200000, 100000, N'CASE      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP8                 ', N'Thùng máy tính/ Case ASUS PRIME AP201 TG BLACK', 1700000, 7, N'ASUS', CAST(N'2011-02-21' AS Date), 12, 1400000, 100000, N'CASE      ')
INSERT [dbo].[SanPham] ([maSanPham], [tenSanPham], [giaBan], [soLuongTonKho], [nhaSanXuat], [ngaySanXuat], [baoHanh], [giaNhap], [giamGia], [loaiSanPham]) VALUES (N'SP9                 ', N'Thùng máy tính/ Case ASUS PRIME AP201 TG WHITE', 1800000, 14, N'ASUS', CAST(N'2011-04-22' AS Date), 12, 1600000, 100000, N'CASE      ')
GO
INSERT [dbo].[VGA] ([maSanPham], [tienTrinh], [TDP], [cudaCores]) VALUES (N'SP41                ', 7, 20, 4)
INSERT [dbo].[VGA] ([maSanPham], [tienTrinh], [TDP], [cudaCores]) VALUES (N'SP42                ', 7, 18, 3)
INSERT [dbo].[VGA] ([maSanPham], [tienTrinh], [TDP], [cudaCores]) VALUES (N'SP43                ', 10, 15, 6)
INSERT [dbo].[VGA] ([maSanPham], [tienTrinh], [TDP], [cudaCores]) VALUES (N'SP44                ', 10, 22, 4)
INSERT [dbo].[VGA] ([maSanPham], [tienTrinh], [TDP], [cudaCores]) VALUES (N'SP45                ', 12, 12, 6)
INSERT [dbo].[VGA] ([maSanPham], [tienTrinh], [TDP], [cudaCores]) VALUES (N'SP46                ', 12, 18, 5)
INSERT [dbo].[VGA] ([maSanPham], [tienTrinh], [TDP], [cudaCores]) VALUES (N'SP47                ', 9, 25, 6)
INSERT [dbo].[VGA] ([maSanPham], [tienTrinh], [TDP], [cudaCores]) VALUES (N'SP48                ', 9, 20, 3)
INSERT [dbo].[VGA] ([maSanPham], [tienTrinh], [TDP], [cudaCores]) VALUES (N'SP49                ', 8, 21, 7)
INSERT [dbo].[VGA] ([maSanPham], [tienTrinh], [TDP], [cudaCores]) VALUES (N'SP50                ', 8, 15, 6)
GO
ALTER TABLE [dbo].[CASE]  WITH CHECK ADD  CONSTRAINT [FK_CASE_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[CASE] CHECK CONSTRAINT [FK_CASE_SanPham]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_SanPham]
GO
ALTER TABLE [dbo].[CPU]  WITH CHECK ADD  CONSTRAINT [FK_CPU_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CPU] CHECK CONSTRAINT [FK_CPU_SanPham]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang1] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([ma])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang1]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([ma])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_ConNguoi] FOREIGN KEY([ma])
REFERENCES [dbo].[ConNguoi] ([ma])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_ConNguoi]
GO
ALTER TABLE [dbo].[MAIN]  WITH CHECK ADD  CONSTRAINT [FK_MAIN_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[MAIN] CHECK CONSTRAINT [FK_MAIN_SanPham]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ConNguoi] FOREIGN KEY([ma])
REFERENCES [dbo].[ConNguoi] ([ma])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ConNguoi]
GO
ALTER TABLE [dbo].[PSU]  WITH CHECK ADD  CONSTRAINT [FK_PSU_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PSU] CHECK CONSTRAINT [FK_PSU_SanPham]
GO
ALTER TABLE [dbo].[RAM]  WITH CHECK ADD  CONSTRAINT [FK_RAM_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[RAM] CHECK CONSTRAINT [FK_RAM_SanPham]
GO
ALTER TABLE [dbo].[VGA]  WITH CHECK ADD  CONSTRAINT [FK_VGA_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[VGA] CHECK CONSTRAINT [FK_VGA_SanPham]
GO
