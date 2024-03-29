USE [master]
GO
/****** Object:  Database [ProjectHealthApp]    Script Date: 15-11-2019 10:25:47 ******/
CREATE DATABASE [ProjectHealthApp]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ProjectHealthApp', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\ProjectHealthApp.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ProjectHealthApp_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\ProjectHealthApp_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [ProjectHealthApp] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProjectHealthApp].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProjectHealthApp] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProjectHealthApp] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProjectHealthApp] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProjectHealthApp] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProjectHealthApp] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET RECOVERY FULL 
GO
ALTER DATABASE [ProjectHealthApp] SET  MULTI_USER 
GO
ALTER DATABASE [ProjectHealthApp] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProjectHealthApp] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProjectHealthApp] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProjectHealthApp] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProjectHealthApp] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'ProjectHealthApp', N'ON'
GO
ALTER DATABASE [ProjectHealthApp] SET QUERY_STORE = OFF
GO
USE [ProjectHealthApp]
GO
/****** Object:  Table [dbo].[tblHealthRecord]    Script Date: 15-11-2019 10:25:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblHealthRecord](
	[fldRecordID] [int] IDENTITY(1,1) NOT NULL,
	[fldWeek] [tinyint] NULL,
	[fldExercisedHours] [decimal](18, 2) NULL,
 CONSTRAINT [PK_tblHealthRecord] PRIMARY KEY CLUSTERED 
(
	[fldRecordID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [ProjectHealthApp] SET  READ_WRITE 
GO
