%%% Identification

\def\fileversion{1.00}
\def\filedate{2020/12/25}

% Sets the LaTeX version for the package to work.
\NeedsTeXFormat{LaTeX2e}

% Identification of the class and its date and version.
\ProvidesClass{preamble}[\filedate\space\fileversion TU Darmstadt - Publication template]

%%% Document class

% imakeidx must be loaded before hyperref or else  the hyperlinks for the index are not working.
\AddToHook{package/before/hyperref}{\RequirePackage{imakeidx}}

% Document color
\newcommand*{\documentcolor}{9c}

% tudapub
% This can be customized depending on what is needed.
\LoadClass[
	class = report,
	color = \documentcolor,
    colorback = false,
    marginpar = false,
    ngerman,
    type = intern,
    listof = totoc
]{tudapub}

%%% Packages

%% Biblopgraphy
\RequirePackage[
    backend = biber,
    maxbibnames = 99,
    sorting = ynt,
    style = alphabetic
]{biblatex}

%% Box
\RequirePackage{tcolorbox}
	
%% Caption
% Centering caption
\RequirePackage[justification = centering]{caption}

%% Color
\RequirePackage{xcolor}

%% Graphics
% Graphics path
\RequirePackage{float}
\RequirePackage{graphicx}
\RequirePackage{tikz}

%% Index
\RequirePackage{imakeidx}

%% KOMA-Script
% Using Koma's float algorithm
\RequirePackage{scrhack}

%% Language
\RequirePackage[english, main = ngerman]{babel}
% Quotes
\RequirePackage[babel]{csquotes}

%% List
\RequirePackage{enumitem}

%% Math
\RequirePackage{amsmath, amssymb}
% Lightning symbol
\RequirePackage{stmaryrd}

%% Standalone
% Import document content from another direcotry or different document.
% Usage: \import{path}{file.tex}
\RequirePackage{import}
% Creating standalone documents to add them as sub document to the main document.
\RequirePackage{standalone}

%% Table
\RequirePackage{booktabs}

%%% Colors

\colorlet{preamblecolor}{TUDa-\documentcolor}

%%% Index

%% Style
% Heading color
\newcommand*{\indexheadingcolor}{preamblecolor}

%% Gloassary
% Indent
\makeatletter
\def\@idxitem{\par\hangindent 0pt}
\makeatother

%% Language
% Index name
\providecaptionname{ngerman, german}{\indexnamelanguage}{Stichwortverzeichnis}
\providecaptionname{english, american, british}{\indexnamelanguage}{Index}
% Numbers
\providecaptionname{ngerman, german}{\indexnumbername}{Zahlen}
\providecaptionname{english, american, british}{\indexnumbername}{Numbers}

% Symbols
\providecaptionname{ngerman, german}{\indexsymbolname}{Symbole}
\providecaptionname{english, american, british}{\indexnamelanguage}{Symbols}

%%% Settings

%% Bibliography
% Language
\providecaptionname{ngerman, german}{\bibliographynamelanguage}{Literaturverzeichnis}
\providecaptionname{english, american, british}{\bibliographynamelanguage}{Bibliography}
% Url line break
\setcounter{biburllcpenalty}{7000}
\setcounter{biburlucpenalty}{8000}

%% Box
\tcbset{
	colframe = preamblecolor
}

%% Digit
% Prefix filling 0 if the number is smaller than 10.
\newcommand*{\twodigits}[1]{\ifnum #1 < 10 0#1\else #1\fi}

%% KOMA-Script
% Unbold title
\addtokomafont{author}{\mdseries}
\addtokomafont{date}{\mdseries}

%% Paragraph
% Indent
\setlength{\parindent}{0pt}
% Line break and no indent
\let\oldparagraph\paragraph
\renewcommand*{\paragraph}[1]{\oldparagraph{#1}\hfill}
\setlength\parindent{0pt}


%% Table of content
% Page break in table of contents
\newcommand*{\cleartoc}{\addtocontents{toc}{\protect\clearpage}}

%% Text
% Linke break
\newcommand*{\br}{\vskip .5em}

%% Tikz
% Index custom theme
\usetikzlibrary{shadows.blur, shapes}

%%% Title format

\makeatletter
%% Author
\providecaptionname{ngerman, german}{\autorname}{Autoren}
\providecaptionname{english, american, british}{\autorname}{Authors}

% Author sep
\providecaptionname{ngerman, german}{\authorsep}{und~}
\providecaptionname{english, american, british}{\authorsep}{and~}

%% Current version
\newcommand*{\@version}{\today}
\newcommand*{\version}[1]{\renewcommand*{\@version}{#1}}
\providecaptionname{ngerman, german}{\versionname}{Version}
\providecaptionname{english, american, british}{\versionname}{Version}

%% Department
\newcommand*{\@department}{}
\newcommand*{\department}[1]{\renewcommand*{\@department}{#1}}
\providecaptionname{ngerman, german}{\departmentname}{Fachbereich}
\providecaptionname{english, american, british}{\departmentname}{Department}

%% Semester
\newcommand*{\@semester}{}
\newcommand*{\semester}[1]{\renewcommand*{\@semester}{#1}}
\providecaptionname{ngerman, german}{\semestername}{Semester}
\providecaptionname{english, american, british}{\semestername}{Semester}

%% maketitle
\ExplSyntaxOn
\makeatletter
\renewcommand*{\@maketitle}{%
	\global\@topnum=\z@
	\setparsizes{\z@}{\z@}{\z@\@plus 1fil}\par@updaterelative
	\vspace*{-\dim_eval:n {
			\headheight
			+\headsep
			+\topskip
			-\box_ht:N\ptxcd_headrule_box
			-\box_dp:N \ptxcd_headrule_box
	}}
	\par
	\nointerlineskip
	\begingroup
	\usekomafont{disposition}
	\hsize=\g_ptxcd_headwidth_dim
	\setlength{\fboxsep}{\z@}
	\bool_if:NT \g_ptxcd_colorback_bool {\colorbox{accentcolor}}{\parbox[t]{\g_ptxcd_headwidth_dim}{
			\rule{\z@}{.5\c_ptxcd_logoheight_dim}\par\nointerlineskip
			\raisebox{-\height}{%
				\begin{minipage}[t]{\dimexpr\linewidth-2.2\c_ptxcd_logoheight_dim-1ex}
					\bool_if:NT \g_ptxcd_colorback_bool  {\begin{addmargin}{.5\c_ptxcd_largerule_dim}}
						\raggedright
						\bool_if:NT \g_ptxcd_colorback_bool {\color{textonaccentcolor}}
						\tl_if_empty:NF \@titlehead {\usekomafont{titlehead}{\@titlehead\par}}
						\leavevmode
						{\Huge\usekomafont{title}{
						\Huge
						\@title \par
						}}%
						\vskip .5em
						{\Large\usekomafont{subtitle}{
						% Adjust hspace to align subtitle under title
						\hspace*{.05em}
						\Large
						\@subtitle \par
						}}%
						\vskip 1em
						\bool_if:NTF \g_ptxcd_colorback_bool {\end{addmargin}} {\par}
			\vspace{\dim_eval:n {\c_ptxcd_largerule_dim+\c_ptxcd_rulesep_dim}}
			\end{minipage}
		}
		\hfill
		\raisebox{-\height}{
		\ptxcd_setup_title_box:
		\makebox[2.2\c_ptxcd_logoheight_dim][l]{
		\box_use:N \g_ptxcd_title_info_box
		}
		}
		\dim_compare:nNnTF {\box_ht:N \g_ptxcd_title_info_box + \box_ht:N \g_ptxcd_title_info_box} > {1.1\c_ptxcd_logoheight_dim}
				{\vspace{\c_ptxcd_largerule_dim}}
				{\vspace{.5\c_ptxcd_logoheight_dim}}

		\par
	}}
	\par
	\nointerlineskip
	\rule{\g_ptxcd_headwidth_dim}{\g_ptxcd_titlerule_dim}
	\begin{addmargin}{.5\c_ptxcd_largerule_dim}
	\Large
	% Author, Date
	{
	\xdef\@author {\@author}
	\ifx\@author\@empty\else\textbf{\autorname :}~\usekomafont{author}\@author\fi
	\usekomafont{author}
	\hfill\@date\par
	}
	% Department, Semester
	{
	\usekomafont{author}
	\textbf{\departmentname :}~\@department\hfill\@semester\par
	}
	% State
	{
	\usekomafont{author}
	\hfill\textbf{\versionname :}~\@version\par
	}
	\vspace{\c_ptxcd_rulesep_dim}
	\end{addmargin}
	\tl_if_empty:NF \@thanks {
	\par\nointerlineskip
	\rule{\g_ptxcd_headwidth_dim}{\g_ptxcd_titlerule_dim}
	\expandafter\fontsize\ptxcd_titlethanks_fontsize:\selectfont
	\begin{addmargin}{.5\c_ptxcd_largerule_dim}
		\let\footnotetext\ptxcd_title@footnote
		\@thanks
		\vspace{\c_ptxcd_rulesep_dim}
	\end{addmargin}
	\par
	\let\@thanks\@empty
	}
	\par\nointerlineskip
		\rule{\g_ptxcd_headwidth_dim}{\g_ptxcd_titlerule_dim}
	\par
	\endgroup
	\vskip .5\c_ptxcd_logoheight_dim
}%
\makeatother
\ExplSyntaxOff
