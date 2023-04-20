USE LINHKIENMAYTINH
GO
/****** Object:  Table [dbo].[Case]    Script Date: 4/8/2023 3:31:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Case](
	[chatLieu] [nvarchar](20) NOT NULL,
	[mau] [nvarchar](15) NOT NULL,
	[tuongThich] [nvarchar](20) NOT NULL,
	[MaSanPham] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Case] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cpu]    Script Date: 4/8/2023 3:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cpu](
	[soLoi] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[tanSoCoSo] [float] NOT NULL,
	[tanSoTurbo] [float] NOT NULL,
	[boNhoDem] [int] NOT NULL,
	[boNhoToiDa] [int] NOT NULL,
	[MaSanPham] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Cpu] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Main]    Script Date: 4/8/2023 3:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Main](
	[chipSet] [nvarchar](10) NOT NULL,
	[ramHoTro] [nvarchar](10) NOT NULL,
	[cpuHoTro] [nvarchar](10) NOT NULL,
	[doHoa] [nvarchar](20) NOT NULL,
	[oCungHoTro] [nvarchar](20) NOT NULL,
	[MaSanPham] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Main] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Psu]    Script Date: 4/8/2023 3:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Psu](
	[congSuat] [int] NOT NULL,
	[hieuSuat] [int] NOT NULL,
	[tuoiTho] [int] NOT NULL,
	[MaSanPham] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Psu] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ram]    Script Date: 4/8/2023 3:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ram](
	[dungLuong] [int] NOT NULL,
	[tocDo] [int] NOT NULL,
	[MaSanPham] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Ram] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 4/8/2023 3:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [nvarchar](10) NOT NULL,
	[TenSanPham] [nvarchar](20) NOT NULL,
	[GiaBan] [float] NOT NULL,
	[SoLuongTonKho] [int] NOT NULL,
	[NhaSanXuat] [nvarchar](30) NOT NULL,
	[NgaySanXuat] [date] NOT NULL,
	[BaoHanh] [int] NOT NULL,
	[GiaNhap] [float] NOT NULL,
	[GiamGia] [int] NOT NULL,
	[LoaiSanPham] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_SanPham] PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vga]    Script Date: 4/8/2023 3:31:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vga](
	[tienTrinh] [int] NOT NULL,
	[TDP] [int] NOT NULL,
	[cudaCores] [int] NOT NULL,
	[MaSanPham] [nvarchar](10) NOT NULL
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Case]  WITH CHECK ADD  CONSTRAINT [FK_Case_SanPham1] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[Case] CHECK CONSTRAINT [FK_Case_SanPham1]
GO
ALTER TABLE [dbo].[Cpu]  WITH CHECK ADD  CONSTRAINT [FK_Cpu_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[Cpu] CHECK CONSTRAINT [FK_Cpu_SanPham]
GO
ALTER TABLE [dbo].[Main]  WITH CHECK ADD  CONSTRAINT [FK_Main_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[Main] CHECK CONSTRAINT [FK_Main_SanPham]
GO
ALTER TABLE [dbo].[Psu]  WITH CHECK ADD  CONSTRAINT [FK_Psu_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[Psu] CHECK CONSTRAINT [FK_Psu_SanPham]
GO
ALTER TABLE [dbo].[Vga]  WITH CHECK ADD  CONSTRAINT [FK_Vga_SanPham] FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[Vga] CHECK CONSTRAINT [FK_Vga_SanPham]
GO
