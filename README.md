#使用终端命令行将本地项目上传到Github并提交代码 

##第一步： 在Github上创建自己的repository
##第二步：建立本地仓库cd到你的本地项目根目录下，执行git命令
1：$ cd 到你的项目目录下
2：$ git init
##第三步：将本地项目工作区的所有文件添加到暂存区
3：$ git add . 
##第三步：将暂存区的文件提交到本地仓库
4：$ git commit -m "注释"
##第五步：将本地仓库关联到Github上
5：$ git remote add origin https://github.com/sk95120/-offer.git  用自己的url（创建的仓库的地址，赋值地址栏里面的地址即可）
这步骤如果提示错误：fatal: remote origin already exists. 解决办法如下：
　　1、先删除远程 Git 仓库 $ git remote rm origin 
　　2、再重新添加远程 Git 仓库 $ git remote add origin https://github.com/sk95120/-offer.git  用自己的url（创建的仓库的地址，赋值地址栏里面的地址即可）
##第六步：同步到服务器
6：$ git push -f origin master