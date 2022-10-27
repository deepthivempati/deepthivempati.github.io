# ci/cd & The Jenkins deployment Process

****************

integrating old code with new is known as ci/CD deployment.

[https://www.sumologic.com/glossary/software-deployment/](https://www.sumologic.com/glossary/software-deployment/)
ci -- continuous integration -- whenever we check in and push the code from local ( via any feature branch) AND THEN merge the code via Pull Request (from source(ex:feature) to destination(ex:develop) the build starts by default (in Jenkins, through jenkins configuration) and after the Build is successful, Jenkins automatically triggers the deployments by default.

## Whats is Jenkins Server
[https://www.infoworld.com/article/3239666/what-is-jenkins-the-ci-server-explained.html](https://www.infoworld.com/article/3239666/what-is-jenkins-the-ci-server-explained.html)

## What is Jenkins Server
[https://www.youtube.com/watch?v=LFDrDnKPOTg](https://www.youtube.com/watch?v=LFDrDnKPOTg)


build--> compile the java code, create archive(jar) or web archive(war) file (bundle of collection).

it ultimately compiles archive(A deployment archive is a compressed file that contains actual entries that is created when you export from the source environment).

cd -- continuous deployment -- the process of deployment (of the jar/war file) after each merge into any of the ENVIRONMENT (DEV, QA, STAGE, TRAIN OR PROD)

deployment -- placing the archive on the server is called deployment.after the deploymnet we can query the server and get the response.

  

default deployment

feature-> gdev, gidev3

develop-> gdev, gidev, gidev3

  

only if we merge code from feature to develop branch, feature branch code will be updated in develop.

if we use dev environment where the data is setup, feature code can be deployed to dev for testing in dev environment

if we use idev environment where the data is setup, feature code can be deployed to idev for testing in idev environment without deploying in dev environment.

once the code passes tests, PR should be raised to develop from feature branch.

After the PR is approved and merged build gets automatically triggered for develop branch and once the build is successful deployment to gdev gidev and gidev3 triggers.

Need to approve for the completion of deployments in dev gidev gidev3. In reporting only gdev and gidev.

  

Note: "develop" is a branch in code Repository (Bitbucket or github) and "dev" (or "iDev", "dev2", "idev2") is an deployment environment.
