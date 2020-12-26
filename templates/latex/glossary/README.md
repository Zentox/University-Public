[![LaTeX](https://img.shields.io/badge/Programming%20Language-LaTeX-blue)](https://www.latex-project.org/)
[![LPPL](https://img.shields.io/badge/License-LPPL%20Version%201.3c-orange)](https://www.latex-project.org/lppl/)

[![Maintenance](https://img.shields.io/badge/Maintenance-Yes-brightgreen)](https://github.com/Zentox/university-public/)
[![Issue](https://img.shields.io/badge/Feedback-Open-1abc9c.svg)](https://github.com/Zentox/university-public/issues)


# Section name
Templates - LaTeX
- glossary

# Description
This directory is used for the use of templates of custom custom glossary theme style.

# Programming Languages
- LaTeX

# Table of Contents
1. [Section leaders](#Section-leaders)
1. [Section structure](#Section-structure)
1. [Installation](#Installation)
1. [Usage](#Usage)
1. [Credits](#Credits)
1. [License](#License)

# Section leaders
Maintainers:
- [Zentox](https://github.com/Zentox)

# Section structure
<pre><code>&#128194;gloassary
 ┗ &#128220;index.ist
</code></pre>

## Meaning of the directories
- documents
    
    This directory contains custom document classes, which can be used for different activities.

- glossary

    This directory contains custom glossary styles for a document.
- packages

     This directory contains custom packages, which can be used for different activities.
- tuda

    This directory contains custom document classes that are used for the Darmstadt University of Technology and can be used for various activities.

# Installation
## Requirements
- TeX-Distribution

    [![MiKTeX](https://img.shields.io/badge/TeX--Distribution-MiKTeX-blue)](https://www.tug.org/texlive/)

    [![TeX Live](https://img.shields.io/badge/TeX--Distribution-TeX%20Live-blue)](https://miktex.org/)

- Packages

    [![TeX Live](https://img.shields.io/badge/CTAN-imakeidx-blue)](https://ctan.org/pkg/imakeidx?lang=en)

    [![TeX Live](https://img.shields.io/badge/CTAN-tikz-blue)](https://www.ctan.org/pkg/pgf)

- LaTeX Editor (Recommended)
Instructions can be found on the following website.


    [![Overleaf](https://img.shields.io/badge/Overleaf-LaTeX-blue)](https://www.overleaf.com/learn/latex/Choosing_a_LaTeX_Compiler)

The instructions how to the templates can be used can be found in the respective sections.

# Usage
1. Import the packge `tikz` and use the the following libraries in your preamble.
    ```tex
    %% Tikz
    % Index custom theme
    \usetikzlibrary{shadows.blur, shapes}
    ```
2. Import the package `imakeidx` into your preamble.
    ```tex
    % Index
    \RequirePackage{imakeidx}
    ```
3. Custom language headers:
    ```tex
    % For custom language dependent headers add the following lines in your preamble
    % Example using KOMA-Script

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
    ```
4. Paste this code snippet into the main file.
    ```tex
    % Index
    \makeindex[
        columns = 3,
        intoc,
        title = \indexnamelanguage,
        options = -s index
    ]
    ```

# License
The license for this directory, if nothing is specified, is [LPPL](LICENSE.md).

Please note that the license can be specified in the respective sections.
