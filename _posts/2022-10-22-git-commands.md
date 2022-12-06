---
title:  "git commands"
date:   2022-10-22 10:54:00
# layout: posts
categories: ['Miscellaneous']
tags: ['Miscellaneous']
---

{% include toc title="Index" %}

Common git commands.

## Project clone
```java
git clone <SSH or Https url or repository path>
```

## Creating fresh Repository

Creating a fresh Project Local
1. Create a repository on Github and copy the repository name.
2. Create an IntelliJ/ Eclipse Project as a new project and goto that path using command prompt using the following command.

```sh
// Initialize a repository
git init

// Add the files you have worked upon
git add . #(it will take care of ignore files)

// Commit the changes
git commit -m "About commiting files"
ex: git commit -m "first commit"
```

## Delete branch from remote repository
```sh
git push origin --delete [branchname]

// Delete branch from local repository
git branch -d [branchname]
```

## Rename a branch
```sh
// rename a branch while pointed to any branch
git branch -m <oldname> <newname>

// If you want to rename the current branch, you can simply do:
git branch -m <newname>
```

## Push local branch to repository.
```sh
git push --set-upstream origin <Branch name>
```

```sh
// feature branch needs to be used for development and creating pull request. First checkout the branch from which a new branch is to be created
git checkout <existing develop branch> # Example : develop
git pull  # Optional

// Pull the latest changes from parent branch into child. All the changes in the parent branch must be in the child branch to avoid any conflicts.
git merge <parent branch>

// Create your branch
git checkout -b feature/<branch-name>

// Make your changes  and commit the files
git commit -m <file names>
```

## Swith commits
```sh
// uncommited changes --> Take uncommitted changes from one branch to another.
git checkout -b <new-branch>

// committed changes --> Accidentally if a commit is made in one feature branch instead of other branch.
// First find the commit hash
git cherry-pick 0359ca8b 

// Remove Accidental Pushes from Remote
// Removes the file from the repo but also deletes it from the local file system.
git rm <filename or folder> 

// To remove the file from the remote repo and not delete it from the local file system.
git rm --cached <filename or folder>

// remove from local as well as remote
git rm -r --cached <filename or folder>

// Then commit the changes
```

[ReferenceLink1](https://ndpsoftware.com/git-cheatsheet.html#loc=workspace)
[ReferenceLink2](https://git-school.github.io/visualizing-git/#cherry-pick)

