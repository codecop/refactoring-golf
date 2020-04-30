# Refactoring Golf
![CI](https://github.com/autotraderuk/refactoring-golf/workflows/CI/badge.svg?branch=master)

Refactoring Golf is a game designed to stretch your refactoring muscles and get you to explore your IDE to see what's 
really possible using shortcuts and automation.

This repo contains several source trees, or numbered "Holes" based on a single exercise. Each hole carries on from the 
last for a single exercise - which is the application of a tax amount to a set of monetary amount.

Your goal is to safely and efficiently as possible refactor the Hole-X code to look like the Hole X+1 code. You must aim 
to do it in as few "strokes" as possible.

A "stroke" is essentially a change made to the code, and every stroke costs you points.

Your pairing partner should carefully score you as follows:

- 1 point for every change made to the code using a shortcut or automated IDE feature (e.g., an automated refactoring, code template, or Find/Replace)
- 2 points for every manual edit. Note that a single "edit" could cover multiple lines of code.
- Double points for every change made while the code cannot pass the tests after the previous change.
- Zero points for code formatting (e.g., deleting whitespace or optimizing imports).

Allow yourselves a maximum of 2 attempts at each round to determine your best score.

## Hints: 
1. You may find that customising your IDE is useful (e.g. custom code templates, or even custom refactorings.)

2. If possible, it would be a good idea to have the two versions (Hole X and Hole X+1) of each set of source files open on different machines, as you could easily tie yourself in knots editing the wrong files!

3. Keep that second machine available as a tooling environment. Writing custom tools (scripts, templates etc) costs you zero points in refactoring golf.

## Setup
There are course for [Java](java/README.md), [TypeScript](typescript/README.md) and [Kotlin](kotlin/README.md). 

Choose the course you want to play and follow the instructions.

## Course records:
These are the best known scores:

| Hole | Java | TypeScript | Kotlin | Notes |
|------|------|------------|--------|-------|
| 1    | 3    |            |        |       |
| 2    | 7    |            |        |       |
| 3    | 5    |            |        |       |
| 4    | 6    |            |        |       |
| 5    | 10   |            |        |       |
| 6    | 7    |            |        |       |
 
**Course Record:**
  - Java = 38
  - TypeScript = TBC
  - Kotlin = TBC

## Acknowledgements:
Credit goes to David Denton who created the version we forked. See https://github.com/daviddenton/refactoring-golf.

### Original acknowledgments
This exercise was developed with Ivan (@s4nchez). :)
Thanks to @ivanmoore and @rchatley for the inspiration.
These instructions were mostly stolen from @jasongorman's <a href="https://github.com/jasongorman/RefactoringGolfJava">Refactoring Golf repo</a>
