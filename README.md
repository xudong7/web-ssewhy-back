# SSE-WHY 社区

[![Vue](https://img.shields.io/badge/Vue.js-3.x-4FC08D?style=flat-square&logo=vue.js)](https://vuejs.org/)
[![Element Plus](https://img.shields.io/badge/Element%20Plus-2.x-409EFF?style=flat-square&logo=element)](https://element-plus.org/)
[![Vite](https://img.shields.io/badge/Vite-4.x-646CFF?style=flat-square&logo=vite)](https://vitejs.dev/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.x-6DB33F?style=flat-square&logo=spring-boot)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

SSE-WHY 是一个现代化的技术社区平台，致力于为开发者提供优质的技术交流环境。前端采用 Vue 3 + Element Plus 构建，后端基于 Spring Boot 开发，具有美观的界面和流畅的用户体验。

## 🔗 相关链接

- 前端仓库：[web-ssewhy-front](https://github.com/xudong7/web-ssewhy-front)
- 后端仓库：[web-ssewhy-back](https://github.com/xudong7/web-ssewhy-back)

## ✨ 功能特性

- 📝 文章发布与管理
- 👥 用户关注与互动
- 🔍 智能搜索推荐
- 💬 实时评论交流
- ⭐ 文章收藏与点赞
- 🎨 个性化主页定制
- 📱 响应式布局设计

## 🛠️ 技术栈

### 前端技术
- **前端框架：** Vue 3
- **UI 组件库：** Element Plus
- **构建工具：** Vite
- **状态管理：** Pinia
- **路由管理：** Vue Router
- **HTTP 客户端：** Axios
- **Markdown：** Marked
- **样式处理：** CSS Variables

### 后端技术
- **开发框架：** Spring Boot
- **数据库：** MySQL
- **ORM 框架：** MyBatis
- **API 文档：** Swagger
- **权限认证：** JWT
- **缓存处理：** Redis

## 📦 安装使用

### 前端部署
1. 克隆项目
```bash
git clone https://github.com/xudong7/web-ssewhy-front.git
cd web-ssewhy-front
```

2. 安装依赖
```bash
npm install
```

3. 启动开发服务器
```bash
npm run dev
```

### 后端部署
1. 克隆后端项目
```bash
git clone https://github.com/xudong7/web-ssewhy-back.git
cd web-ssewhy-back
```

2. 配置数据库
- 创建 MySQL 数据库
- 修改 `application.properties` 中的数据库配置

3. 启动项目
```bash
./mvnw spring-boot:run
```

## 🔧 项目配置

1. 前端环境变量配置（创建 `.env` 文件）
```env
VITE_APP_URL=http://localhost:8080/api
```

2. 后端接口配置
```javascript
// src/utils/request.js
const request = axios.create({
  baseURL: import.meta.env.VITE_APP_URL,
  timeout: 5000
})
```

## 📂 目录结构

```
front
├── public/
├── src/
│   ├── api/          # API 接口
│   ├── assets/       # 静态资源
│   ├── components/   # 公共组件
│   ├── layouts/      # 布局组件
│   ├── router/       # 路由配置
│   ├── store/        # 状态管理
│   ├── styles/       # 全局样式
│   ├── utils/        # 工具函数
│   ├── views/        # 页面组件
│   ├── App.vue
│   └── main.js
├── .env
├── index.html
├── package.json
└── vite.config.js
```

## 🌟 主要功能展示

### 首页浏览
- 文章列表展示
- 智能推荐
- 分类导航

### 文章详情
- Markdown 渲染
- 评论互动
- 点赞收藏

### 用户中心
- 个人主页
- 文章管理
- 收藏管理

## 🤝 贡献指南

1. Fork 本仓库
2. 创建特性分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 提交 Pull Request

## 📄 开源协议

本项目基于 [MIT](LICENSE) 协议，请自由地享受和参与开源。

## 🙏 致谢

- [Vue.js](https://vuejs.org/)
- [Element Plus](https://element-plus.org/)
- [Vite](https://vitejs.dev/)
- [Marked](https://marked.js.org/)
