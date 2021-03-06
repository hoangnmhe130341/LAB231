USE [master]
GO
/****** Object:  Database [J3.L.P0013]    Script Date: 4/4/2020 7:23:37 PM ******/
CREATE DATABASE [J3.L.P0013]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'J3.L.P0013', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\J3.L.P0013.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'J3.L.P0013_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\J3.L.P0013_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [J3.L.P0013] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [J3.L.P0013].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [J3.L.P0013] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [J3.L.P0013] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [J3.L.P0013] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [J3.L.P0013] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [J3.L.P0013] SET ARITHABORT OFF 
GO
ALTER DATABASE [J3.L.P0013] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [J3.L.P0013] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [J3.L.P0013] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [J3.L.P0013] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [J3.L.P0013] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [J3.L.P0013] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [J3.L.P0013] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [J3.L.P0013] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [J3.L.P0013] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [J3.L.P0013] SET  ENABLE_BROKER 
GO
ALTER DATABASE [J3.L.P0013] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [J3.L.P0013] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [J3.L.P0013] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [J3.L.P0013] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [J3.L.P0013] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [J3.L.P0013] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [J3.L.P0013] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [J3.L.P0013] SET RECOVERY FULL 
GO
ALTER DATABASE [J3.L.P0013] SET  MULTI_USER 
GO
ALTER DATABASE [J3.L.P0013] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [J3.L.P0013] SET DB_CHAINING OFF 
GO
ALTER DATABASE [J3.L.P0013] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [J3.L.P0013] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [J3.L.P0013] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'J3.L.P0013', N'ON'
GO
ALTER DATABASE [J3.L.P0013] SET QUERY_STORE = OFF
GO
USE [J3.L.P0013]
GO
/****** Object:  Table [dbo].[Article]    Script Date: 4/4/2020 7:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Article](
	[id] [int] NOT NULL,
	[title] [nvarchar](50) NOT NULL,
	[img] [nvarchar](50) NOT NULL,
	[shortContent] [nvarchar](max) NOT NULL,
	[fullContent] [nvarchar](max) NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Information]    Script Date: 4/4/2020 7:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Information](
	[id] [int] NOT NULL,
	[type] [nvarchar](50) NULL,
	[detail] [nvarchar](50) NOT NULL,
	[content] [nvarchar](250) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Menu]    Script Date: 4/4/2020 7:23:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Menu](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[content] [nvarchar](max) NOT NULL,
	[price] [float] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[Article] ([id], [title], [img], [shortContent], [fullContent]) VALUES (1, N'24 types of sushi rolls', N'i282319414620340695._szw480h1280_.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.', N'Sushi is a food preparation originating in Japan, consisting of cooked vinegared rice combined with other ingredients (such as raw seafood, vegetables and sometimes tropical fruits. Ingredients and forms of sushi presentation vary widely, but the ingredient which all sushi have in commonLorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assumLorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.')
INSERT [dbo].[Article] ([id], [title], [img], [shortContent], [fullContent]) VALUES (2, N'Most sushi recently', N'i282319414620330848._szw1280h1280_.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.', N'Sushi is a food preparation originating in Japan, consisting of cooked vinegared rice combined with other ingredients (such as raw seafood, vegetables and sometimes tropical fruits. Ingredients and forms of sushi presentation vary widely, but the ingredient which all sushi have in commonLorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assumLorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.')
INSERT [dbo].[Article] ([id], [title], [img], [shortContent], [fullContent]) VALUES (3, N'Best sushi on the world', N'i282319414620340695._szw480h1280_.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.', N'Sushi is a food preparation originating in Japan, consisting of cooked vinegared rice combined with other ingredients (such as raw seafood, vegetables and sometimes tropical fruits. Ingredients and forms of sushi presentation vary widely, but the ingredient which all sushi have in commonLorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assumLorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.')
INSERT [dbo].[Article] ([id], [title], [img], [shortContent], [fullContent]) VALUES (4, N'Sushi japan famous', N'i282319414620330848._szw1280h1280_.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.', N'Sushi is a food preparation originating in Japan, consisting of cooked vinegared rice combined with other ingredients (such as raw seafood, vegetables and sometimes tropical fruits. Ingredients and forms of sushi presentation vary widely, but the ingredient which all sushi have in commonLorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assumLorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.')
INSERT [dbo].[Article] ([id], [title], [img], [shortContent], [fullContent]) VALUES (5, N'Some sushi shoundnt eating', N'i282319414620340695._szw480h1280_.jpg', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.', N'Sushi is a food preparation originating in Japan, consisting of cooked vinegared rice combined with other ingredients (such as raw seafood, vegetables and sometimes tropical fruits. Ingredients and forms of sushi presentation vary widely, but the ingredient which all sushi have in commonLorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assumLorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum.')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (1, N'imgCover', N'imgCover', N'i282319414620330848._szw1280h1280_.jpg')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (2, N'address', N'address', N'The Sushi Restaurant
New York, NY, USA')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (3, N'tel', N'tel', N'01633911325')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (4, N'mail', N'mail', N'hoangnmhe130341@fpt.edu.vn')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (5, N'work', N'Monday', N'Closed')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (6, N'work', N'Tuesday', N'12 - 22')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (7, N'work', N'Wednesday', N'12 - 22')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (8, N'work', N'Thursday', N'12 - 22')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (9, N'work', N'Friday', N'11 - 23')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (10, N'work', N'Saturday', N'11 - 23')
INSERT [dbo].[Information] ([id], [type], [detail], [content]) VALUES (11, N'work', N'Sunday', N'11 - 22')
INSERT [dbo].[Menu] ([id], [name], [content], [price]) VALUES (1, N'Claritas est etiam processus', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.', 15)
INSERT [dbo].[Menu] ([id], [name], [content], [price]) VALUES (2, N'Duis autem vel eum iriure dolor.', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.', 20)
INSERT [dbo].[Menu] ([id], [name], [content], [price]) VALUES (3, N'Eodem modo typi, qui nunc nobis videntur.', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.', 25)
USE [master]
GO
ALTER DATABASE [J3.L.P0013] SET  READ_WRITE 
GO
