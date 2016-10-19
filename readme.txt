https://github.com/RyanCA/J05_LeetCodes


############################## Git Repository Location #########################
https://github.com/RyanCA

############################## Git Manual ######################################
https://git-scm.com/book/en/v2

############################## If project in Git ##############################
git clone https://github.com/RyanCA/J02_Leetcode_Patterns.git

######################## A: If a project in local already ######################

1. Refer to "Create MVN Project from Scratch For this Project" in readme_mvn.txt to 
create the project and develop it

2. Use git commands below to push resources into git
 
cd ......\eclipse_projects
git init J02_Leetcode_Patterns # .git directory created in local
cd .\J02_Leetcode_Patterns
git add .                         # Add all resources from UNTRACKED To TRACKED
git status                        # Check resources info before commit
git commit -m "Init commit batch" # resources updated from TRACKED to STATGED
git push origin master
 
################################################################################
B: If no repository for your project on Github, then you need do following steps
################################################################################
2.1 create a repo on github through github web UI

2.2 copy the url of new repo and use below commands to associate local and git server 
git remote add origin https://github.com/RyanCA/J02_Leetcode_Patterns.git
git remote -v                     # Check if add remote successfully or not
origin  https://github.com/RyanCA/J02_Leetcode_Patterns.git (fetch)
origin  https://github.com/RyanCA/J02_Leetcode_Patterns.git (push)

################################################################################

################################# Git Notes ####################################
1. Once the repo created on Github, the name can't changed but the project name on eclipse can be changed.
   Eg: the project name is called J01_Spring, later on I changed it to springinaction4thedition to keep it consistent with repo name

############################### Git Tag ########################################
git tag -a v0.1 -m 'Simple Spring MVC with Maven and Eclipse'
git tag
git push origin v0.1              # Push tags into git server

git tag                           # List all tags
git show -v0.1                    # Show specific Tag

#Checkout a specific tag (Page 78 of progit-en.1084.pdf or https://git-scm.com/book/en/v2)
git clone  https://github.com/RyanCA/J02_Leetcode_Patterns.git
cd J02_Leetcode_Patterns
git show v0.2                     # Spring MVC, Spring Security and Spring Exception Handling Done
git checkout -b springmvc v0.2    # -b [branch name] [tag name]
git status                        # Show on springmvc branch now

################################################################################

##############################Git Tag History##################################
Branch         Tag      Description
heroku_local            For heroku development
master         v0.2     Spring MVC, Spring Security and Spring Exception Handling Done
