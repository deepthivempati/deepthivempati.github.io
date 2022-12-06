---
title:  "Back Merging"
date:   2022-12-06 10:54:00
categories: ['Miscellaneous']
tags: ['Miscellaneous']
---
* Merge all the bugfix release changes into develop. After warranty period of the current release is over follow the below pointers.
* For Next(Future) Release we use future-develop as the parent branch where we cut the feature branches from
* Cut the feature branch from future-develop and can start making changes
* Raise a pr from feature branch to future-develop branch. Need to follow the same by raising the pr from feature branches cut from future-develop to future-develop one by one
* **Note**: while merging if there are any conflicts resolve them manually or follow the commands by selecting all the changes appear on the console
 * git checkout feature branch  
 * git pull origin parent branch
 * git commit
 * git push origin Head
* Create feature branch from develop and raise a pr to future-develop branch--so that all the changes of the current release goes into the future develop branch.
* **Example**: Dec 05 2022 -R17 release warranty is over. All the R17 code is in develop branch(including warranty support code changes from bugfix release 17 branch). Merge this branch to future-develop so that all r17 code goes to future-develop branch. 
* Create feature branch from future-develop and create a pull request to develop and merge once the pr is approved which is called as back merging.