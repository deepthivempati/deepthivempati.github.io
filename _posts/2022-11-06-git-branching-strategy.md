---
title:  "Git Branching Strategy"
date:   2022-11-05 18:25:00
categories: ['Miscellaneous']
tags: ['Miscellaneous']
---

## Overview

## **Steps:**
* Develop -> Master(merge on the day of release - Oct 01)
* Next Day(Oct - 02) bugfix/release16 branch creation(all PROD defects from the release, during warrenty period, will be made in this branch)
* After release Warrenty period -> if any PROD defect -> feature from bugfix/Release and merge the feature branch - R16+ code
* After release: Develop branch (All R16 code) is now prepared for next release by back merging the future/develop (which has R17 related code)
* After Warrenty period (2 week) keep making changing in bugfix/release (Release during warrenty period means merging bugfix with master)
* Backmerge from bugfix to develop -> after warrenty (develop will have R17+R16+changes)
* Master Branch -> unicorn-dev branch(PROD equivalent branch)
* suppose next release is on Dec 01, on Nov 01, some emergency defect is logged in PROD - sev1(severe) and p1(Priority) ticket
* Then the emergency hot fix will be made in unicorn-dev(feature merged to unicorn-dev)


## Reference

[Link]: (https://nvie.com/posts/a-successful-git-branching-model) 
