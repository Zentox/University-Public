%%% Identification

\def\fileversion{1.00}
\def\filedate{2020/12/25}

% Sets the LaTeX version for the package to work.
\NeedsTeXFormat{LaTeX2e}

% Identification of the class and its date and version.
\ProvidesClass{preamble}[\filedate\space\fileversion TU Darmstadt - Exercise template]

%%% Document class

% imakeidx must be loaded before hyperref or else  the hyperlinks for the index are not working.
\AddToHook{package/before/hyperref}{\RequirePackage{imakeidx}}

% Document color
\newcommand*{\documentcolor}{9c}

% tudapub
% This can be customized depending on what is needed.
\LoadClass[
    color = \documentcolor,
    colorback = false,
    ngerman,
    solution = true
]{tudaexercise}

%%% Packages

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

%%% Settings

%% Box
\tcbset{
    colframe = preamblecolor
}

%% Credit
% Credit position
\renewcommand*{\creditformat}[1]{\hfill (#1 \creditname)}

% Language
\newcaptionname{ngerman, german}{\creditname}{Punkte}
\newcaptionname{english, american, british}{\creditname}{Points}

%% Digit
% Prefix filling 0 if the number is smaller than 10.
\newcommand*{\twodigits}[1]{\ifnum #1 < 10 0#1\else #1\fi}

%% Paragraph
% Indent
\setlength{\parindent}{0pt}

% Line break and no indent
\let\oldparagraph\paragraph
\renewcommand*{\paragraph}[1]{\oldparagraph{#1}\hfill}
\setlength\parindent{0pt}

%% Subtask
% Counter
\renewcommand*{\thesubtask}{\arabic{subtask}}

% Font
%\setkomafont{subtask}{\mdseries\normalsize}

% Name
% Format Taskname Whitespace Tasknumber Subtasknumber Whitespace
\renewcommand*{\subtaskformat}{\taskname\enskip\thetask{}.\thesubtask\enskip}
%\renewcommand*{\subtaskformat}{\textbf{\taskname\enskip\thetask{}.\thesubtask\enskip}}

%% Table of content
% Page break in table of contents
\newcommand*{\cleartoc}{\addtocontents{toc}{\protect\clearpage}}

%% Task
% Counter
\renewcommand*{\thetask}{\arabic{task}}

% Font
%\setkomafont{task}{\mdseries\normalsize}

% Language
\renewcaptionname{ngerman}{\taskname}{Aufgabe}
\renewcaptionname{english}{\taskname}{Task}

% Name
% Format Taskname Whitespace Tasknumber
\renewcommand*{\taskformat}{\taskname\enskip\thetask{}}
%\renewcommand*{\taskformat}{\textbf{\taskname\enskip\thetask{}}}

% Task seperator
\ExplSyntaxOn
\renewcommand*\sectionlinesformat[4]{%
    \parbox{\linewidth}{
        \rule[5\g_ptxcd_titlerule_dim]{\linewidth}{\g_ptxcd_titlerule_dim}\par\nointerlineskip
        \@hangfrom{%
            \hskip #2#3}{
            \tl_if_eq:nnT {#1} {task} {
                \exp_args:No \tl_if_empty:nF {#4}
                {~} % Insert your task seperator here. Default ~: Whitespace
            }
            #4
            \tl_if_in:nnT {#1} {task} {
                \tl_if_empty:cTF{l_ptxcd_ex_#1_credit_tl}
                {\pointformat{\tl_use:c {l_ptxcd_ex_#1_points_int}}}
                {\creditformat{\tl_use:c {l_ptxcd_ex_#1_credit_tl}}}
            }
            \rule[-\dp\strutbox]{0pt}{\dp\strutbox}\par}\nointerlineskip
        \skip_vertical:n {\ptxcd_titlerule_sep: -\dp\strutbox}
        \smash{\rule{\linewidth}{\g_ptxcd_titlerule_dim}}
    }}
\ExplSyntaxOff

%% Text
% Linke break
\newcommand*{\br}{\vskip .5em}

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

%% Sheet number
\ExplSyntaxOn
\renewcommand*{\sheetnumber}[1]{\tl_gset:Nn \g_ptxcd_ex_sheetnum_tl {\twodigits{#1}}}
\ExplSyntaxOff

%% \maketitle
\makeatletter
\ExplSyntaxOn
\renewcommand*{\@maketitle}{%
    \global\@topnum=\z@
    \setparsizes{\z@}{\z@}{\z@\@plus 1fil}\par@updaterelative
    \vspace*{-\dim_eval:n {
            \headheight
            -\c_ptxcd_largerule_dim -\c_ptxcd_rulesep_dim
            +\headsep
            +\ht\strutbox
            +\p@
        }}
    \par
    \nointerlineskip
    \begingroup
    \setlength{\fboxsep}{\z@}
    \bool_if:NT \g_ptxcd_colorback_bool {\colorbox{accentcolor}}{\parbox[t]{\linewidth}{
            \rule{0pt}{\bool_if:NTF \g_ptxcd_smalltitle_bool {.25} {.5}\c_ptxcd_logoheight_dim}
            \par\nointerlineskip
            \raisebox{-\height}{%
                \begin{minipage}[t]{\dimexpr\linewidth-2.2\c_ptxcd_logoheight_dim-1ex}
                    \bool_if:NT \g_ptxcd_colorback_bool  {\begin{addmargin}{3mm}}
                            \raggedright
                            \bool_if:NT \g_ptxcd_colorback_bool {\color{textonaccentcolor}}
                            \tl_if_empty:NF \@titlehead {\usekomafont{titlehead}{\@titlehead\par}}
                            \leavevmode\usekomafont{title}%
                            {\usekomafont{title}\bool_if:NTF \g_ptxcd_smalltitle_bool {\LARGE} {\huge} {\@title\par}}%
                            \vskip 1em
                            \bool_if:NF \g_ptxcd_ex_compatibility_bool
                            {
                                {\ifx\@subtitle\@empty\else\usekomafont{subtitle}\@subtitle\par\fi}%
                                \gdef\@subtitle{}
                                \vskip .5em
                            }
                            \vskip .5em
                            \bool_if:NTF \g_ptxcd_colorback_bool {\end{addmargin}} {\par}
                \end{minipage}}
            \tl_if_empty:NF \g_ptxcd_logofile_tl {
                \hfill\raisebox{\dim_eval:n {
                        \bool_if:NTF \g_ptxcd_colorback_bool
                        {-\height}
                        {-.9\c_ptxcd_logoheight_dim}
                    }}
                [0pt]
                [\dim_eval:n {
                        \bool_if:NTF \g_ptxcd_smalltitle_bool
                        {\bool_if:NTF \g_ptxcd_colorback_bool {1.15}{1}}
                        {\bool_if:NTF \g_ptxcd_colorback_bool {1.5}{1.3}
                        }\c_ptxcd_logoheight_dim}]
                {\makebox[2.2\c_ptxcd_logoheight_dim][l]{\includegraphics[height=\c_ptxcd_logoheight_dim]{\g_ptxcd_logofile_tl}}}
            }
            \par\medskip
        }}
    \par
    \nointerlineskip
    \rule{\linewidth}{\g_ptxcd_titlerule_dim}
    % subtitle fields if not compat
    \exp_args:Nf \tl_if_empty:nF {\g_ptxcd_ex_sheetnum_tl\@date\g_ptxcd_ex_term_tl\use:c {@subsubtitle}\@subtitle}{
        \par\nointerlineskip
        \bool_if:NT \g_ptxcd_colorback_bool {\colorbox{accentcolor}}{
            \parbox{\linewidth}{
                \begin{minipage}{\linewidth}
                    \bool_if:NT \g_ptxcd_colorback_bool {
                        \color{textonaccentcolor}
                        \begin{addmargin}{3mm}
                            }
                            \null\par
                            \def\ptxcd_nextsep{}
                            \clist_map_inline:nn {@subtitle} {
                                \tl_if_empty:cF {##1} {\ptxcd_nextsep\use:c {##1}\def\ptxcd_nextsep{\\}}
                            }
                            % Author, Date
                            {
                                \xdef\@author {\@author}
                                \ifx\@author\@empty\else\textbf{\autorname :}~\usekomafont{author}\@author\fi
                                \hfill\@date\par
                            }
                            % Department, Semester
                            {
                                \textbf{\departmentname :}~\@department\hfill\@semester\par
                            }
                            % Sheetnumber, Current State
                            {
                                \tl_if_empty:NF \g_ptxcd_ex_sheetnum_tl {\ptxcd_nextsep\textbf{\sheetname}:\sheetsep\g_ptxcd_ex_sheetnum_tl}
                                \hfill\textbf{\versionname :}~\@version\par
                            }
                            \bool_if:NT \g_ptxcd_colorback_bool {\end{addmargin}}
                \end{minipage}
                \vspace*{\dp\strutbox}
            }}\par\nointerlineskip
        \rule{\linewidth}{\g_ptxcd_titlerule_dim}
    }
    \par
    \bool_if:NT  \g_ptxcd_headontitle_bool {
        \if@twoside
            \box_use:N \g_ptxcd_ex_headline_odd_box
        \else
            \box_use:N \g_ptxcd_ex_headline_oneside_box
        \fi
        \par
        \rule{\linewidth}{\g_ptxcd_titlerule_dim}
        \par
    }
    \endgroup
    \vskip 2em
    \ConfigureHeadline{}
}%
\ExplSyntaxOff
\makeatother
