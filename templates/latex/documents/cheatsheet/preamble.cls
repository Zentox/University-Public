%%% Identification

\def\fileversion{2.00}
\def\filedate{2020/12/25}

% Sets the LaTeX version for the package to work.
\NeedsTeXFormat{LaTeX2e}

% Identification of the class and its date and version.
\ProvidesClass{preamble}[\filedate\space\fileversion Cheatsheet template]

% article
% This can be customized depending on what is needed.
\LoadClass[
    10pt,
    landscape,
    ngerman,
    a4paper
]{article}

%% Box
\RequirePackage{tcolorbox}

%% Caption
% Centering caption
\RequirePackage[
    font = small,
    justification = centering
]{caption}

% Expl3
\RequirePackage{expl3}

%% Geometry
% Page margins
\RequirePackage[
    top = 7.5mm,
    bottom = 7.5mm,
    left = 7.5mm,
    right = 7.5mm
]{geometry}

%% Graphics
% Graphics path
\RequirePackage{float}
\RequirePackage{graphicx}
\RequirePackage{tikz}

%% Language
\RequirePackage[english, ngerman]{babel}
% Quotes
\RequirePackage[babel]{csquotes}
% Caption name
\RequirePackage{scrbase}

%% List
\RequirePackage{enumitem}

%% Math
\RequirePackage{amsmath, amssymb}
% Lightning symbol
\RequirePackage{stmaryrd}

%% Multi columns
\RequirePackage{multicol}

%% Section
\RequirePackage{titlesec}

%% Standalone
% Import document content from another direcotry or different document.
% Usage: \import{path}{file.tex}
\RequirePackage{import}
% Creating standalone documents to add them as sub document to the main document.
\RequirePackage{standalone}

%% Table
\RequirePackage{booktabs}

%%% Settings

%% Author
\makeatletter
\renewcommand{\author}[1]{\def\@author{#1}}
\def\@author{}
\makeatother

%% Box
\tcbset{
    fonttitle = \small\bfseries\sffamily,
}

\ExplSyntaxOn
% Cheatsheet document environment
\newenvironment{cheatcols}
{
    \bool_if:NF \l__cheatsheet_bool{%
        \begin{multicols*}{3}
            \small
            }
            }
            {
            \bool_if:NF \l__cheatsheet_bool{%
            \raggedcolumns
        \end{multicols*}
    }
}
\ExplSyntaxOff

% Cheatsheet box
\newenvironment{cheatbox}[1]
{
    \small
    \begin{center}
        \textbf{#1}
    \end{center}
    \unskip
    \rule{\linewidth}{0.4pt}
}
{
}

%% Digit
% Prefix filling 0 if the number is smaller than 10.
\newcommand*{\twodigits}[1]{\ifnum #1 < 10 0#1\else #1\fi}

%% Expl3
\ExplSyntaxOn
% Boolean to check if multicol is used.
\bool_new:N \l__cheatsheet_bool
\bool_new:N \l__cheatsheet_tmp_bool

\bool_set_false:N \l__cheatsheet_bool

% Removes nested mutli columns.
\newcommand*{\turnoff}{\bool_set_true:N \l__cheatsheet_bool}
\ExplSyntaxOff

%% Language
\providecaptionname{ngerman, german}{\maketitlesep}{von}
\providecaptionname{english, american, british}{\maketitlesep}{from}

%% List
\setlist{leftmargin = 1em}

%% Page
\pagestyle{empty}

%% Paragraph
% Indent
\setlength{\parindent}{0pt}

%% Section
\titleformat*{\section}{\small\bfseries}
\titleformat*{\subsection}{\small\bfseries}
\titleformat*{\subsubsection}{\small\bfseries}

%% Title
\makeatletter
\renewcommand*{\@maketitle}{
    \begin{center}
        {\LARGE{\textbf{\@title\ifx\@author\@empty\else~\maketitlesep~\@author\fi}}}
    \end{center}
}
\renewcommand*{\maketitle}{\@maketitle}
\makeatother
