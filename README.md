# CalBridge-Github-Repo

## Steps to Upload these files to Github
 - Create new folder `mkdir [folder name]`
 - `cd [folder name]`
 - `git init`
 - You need to remove the large files for it to work as well 
 - `git add .`
 - `git commit -m "[insert information here]"`
 - `git remote add origin https://github.com/melonpocky/CalBridge-Github-Repo.git` to connect with this repo
 - `git push --set-upstream origin master`
 - if you have an online empty github repo you may need to use the following commands:
   - `git checkout master`
   - `git branch main master -f`
   - `git checkout main`
   - `git push origin main -f`
