USE [LINHKIENMAYTINH]
GO
/****** Object:  Table [dbo].[CASE]    Script Date: 4/15/2023 3:09:31 PM ******/
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
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 4/15/2023 3:09:31 PM ******/
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
/****** Object:  Table [dbo].[ConNguoi]    Script Date: 4/15/2023 3:09:31 PM ******/
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
/****** Object:  Table [dbo].[CPU]    Script Date: 4/15/2023 3:09:31 PM ******/
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
/****** Object:  Table [dbo].[HoaDon]    Script Date: 4/15/2023 3:09:31 PM ******/
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
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 4/15/2023 3:09:31 PM ******/
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
/****** Object:  Table [dbo].[MAIN]    Script Date: 4/15/2023 3:09:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAIN](
	[maSanPham] [nchar](20) NOT NULL,
	[chipSet] [nvarchar](20) NULL,
	[ramHoTro] [nvarchar](20) NULL,
	[cpuHoTro] [nvarchar](20) NULL,
	[doHoa] [nvarchar](20) NULL,
	[oCungHoTro] [nvarchar](20) NULL,
 CONSTRAINT [PK_MAIN1] PRIMARY KEY CLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/15/2023 3:09:31 PM ******/
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
/****** Object:  Table [dbo].[PSU]    Script Date: 4/15/2023 3:09:31 PM ******/
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
/****** Object:  Table [dbo].[RAM]    Script Date: 4/15/2023 3:09:31 PM ******/
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
/****** Object:  Table [dbo].[SanPham]    Script Date: 4/15/2023 3:09:31 PM ******/
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
/****** Object:  Table [dbo].[VGA]    Script Date: 4/15/2023 3:09:31 PM ******/
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
ALTER TABLE [dbo].[CASE]  WITH CHECK ADD  CONSTRAINT [FK_CASE_SanPham] FOREIGN KEY([maSanPham])
REFERENCES [dbo].[SanPham] ([maSanPham])
GO
ALTER TABLE [dbo].[CASE] CHECK CONSTRAINT [FK_CASE_SanPham]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
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
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([ma])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
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
