%%% Identification

\def\fileversion{1.00}
\def\filedate{2020/12/25}

% Sets the LaTeX version for the package to work.
\NeedsTeXFormat{LaTeX2e}

% Identification of the class and its date and version.
\ProvidesClass{preamble}[\filedate\space\fileversion TU Darmstadt - Beamer template]

% Document color
\newcommand*{\documentcolor}{9c}

% tudabeamer
% This can be customized depending on what is needed.
\LoadClass[
    aspectratio = 169,
    authorontitle = true,
    color={accentcolor = 9c},
    colorframetitle = false,
    logo = true,
    ngerman
]{tudabeamer}

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

%% Text
% Linke break
\newcommand*{\br}{\vskip .5em}

%%% Title information
\author[Custom author in Footer]{Author}
\department{Department}
\institute[Custom institute in Footer]{Institute}
\date{\today}
