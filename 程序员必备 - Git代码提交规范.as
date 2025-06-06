程序员必备 - Git代码提交规范
1、提交信息格式
提交格式应为：前缀：简要描述，如：
feat: 新增用户注册功能
fix: 修复订单页面显示错误
style: 删除无用的控制台打印
2、以下是常用的提交信息前缀分类和作用
1）功能相关
feat：新增功能或页面（例如：feat: 增加用户登录功能）
fix：修复Bug或问题（例如：fix: 修复登录页面的登录失败Bug）
modify：修改已有功能（例如：modify: 修改订单页面的支付功能）
delete：删除功能或文件（例如：delete: 删除旧版支付页面）
2）优化/重构相关
perf：优化代码或性能改进（例如：perf: 提升查询性能）
refactor：重构代码，不涉及功能新增或Bug修复（例如：refactor: 重构用户管理模块）
3）样式和文档相关
style：代码风格变动，和功能无关（例如：style: 规范化代码缩进和格式）
docs：文档修改或注释变更（例如：docs: 更新API使用文档）
4）构建和工具相关
build：构建工具或依赖相关的更改（例如：build: 添加webpack配置）
chore：对非src或test的项目配置修改（例如：chore: 更新依赖库）
ci：持续集成配置相关的修改（例如：ci: 修改GitHub Actions的构建流程）
5）测试和自动化
test：新增或修改测试用例（例如：test: 添加用户模块的单元测试）
workflow：工作流改进（例如：workflow: 优化CI工作流）
6）其他
revert：撤销某次提交（例如：revert: 回滚上次对登录功能的修改）
types：修改类型定义文件（例如：types: 更新TypeScript类型定义）
wip：开发中，未完成的提交（例如：wip: 初始化用户管理功能）
3、提交规范总结
1）每次提交只能包含同一类别的改动，不要把不同类型的改动混合在同一次提交中。
2）每次提交不能超过3个问题，确保每个提交的改动清晰明确。
3）提交信息不符合规范时，可以使用 git commit --amend修改，或者使用git reset --hard回退提交。