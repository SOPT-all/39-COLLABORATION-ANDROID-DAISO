# 39-COLLABORATION-ANDROID-DAISOMALL
39기 PLAY SOPT 합동 세미나 안드로이드 1조 다이소 몰 👛
<img height="150" alt="image" src="https://github.com/user-attachments/assets/6b5e3fd9-d801-4bbc-b4b6-792cdce9b3bd" />

<br/>

## **✨ Contributors**

|            👑 박찬미<br/>[@chanmi1125](https://github.com/chanmi1125)            |            송서현<br/>[@Hiimynameiss](https://github.com/Hiimynameiss)            |             신효정<br/>[@hyojeong0714](https://github.com/hyojeong0714)             |               조서현<br/>[@hyuniii0920](https://github.com/hyuniii0920)               |
|:--------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------:|
| <img src="https://github.com/user-attachments/assets/fcf865ca-9ac5-4110-b1ea-334b7b73aa05" height="200" /> | <img src="https://github.com/user-attachments/assets/b0fd6aad-fbf8-4c3c-a7d5-bc8e050a4dfd" height="180" /> | <img src="https://github.com/user-attachments/assets/68ae142b-d5a5-4537-af78-c62dfa81893e" height="150" /> | <img src="https://github.com/user-attachments/assets/4ab56d5a-a7e0-4c86-b1d9-b86638e7c520" height="150" /> |
|                                     `전체 총괄`                                     |                                `검색`                                 |                            `홈`                          |                                       `재고 조회`                                        |

<br/>

## **⚒️ Tech Stacks**

| 항목 | 기술 스택                                                  |
| :--- |:-------------------------------------------------------|
| Architecture | Google Recommended Architecture                        |
| Pattern | MVVM                                                   |
| DI | Manual Dependency Injection                            |
| Asynchronous | Coroutine, Flow                                        |
| Network | Retrofit2, OkHttp                                      |
| Navigation | Single Activity Architecture (SAA), Jetpack Navigation |
| UI Framework | Jetpack Compose                                        |
| Logging | Timber                                                 |

<br/>

## 📸 시연 영상

https://github.com/user-attachments/assets/65d397b9-c9f7-4214-b87c-db76447b7522

<br/>

## **📜 Convention**

- [**Github Convention**](https://app.notion.com/p/sopt-official/4111e48dd960803ab346c92d3da5b384?source=copy_link)
- [**Naming Convention**](https://app.notion.com/p/sopt-official/4111e48dd960803aa721ec684f1982c6?source=copy_link)

<br/>

## **🗂️ Project Structure**

```text
daisomall
├── 📂 core
|   ├── 📂 common
│   │   ├── 📁 extensions   # 확장함수
│   │   └── 📁 util         # 공통 유틸
│   ├── 📂 designsystem
│   │   ├── 📁 component    # 공통 UI 컴포넌트
│   │   └── 📁 theme        # 색상, 타이포, 테마
│   ├── 📁 di               # 의존성 주입(ViewModelFactory)
│   ├── 📁 navigation       # 네비게이션 라우트 정의
│   └── 📁 network          # 네트워크 설정
│
├── 📂 data
│   ├── 📂 datasource  
│   |   ├── 📁 api      # DataSource 인터페이스
│   │   └── 📁 impl     # DataSource 구현체
│   ├── 📁 dto          # API 요청/응답 DTO
│   ├── 📁 mapper       # DTO → Model 변환
│   ├── 📁 model        # 도메인 모델
│   ├── 📂 repository
│       ├── 📁 api      # Repository 인터페이스
│       └── 📁 impl     # Repository 구현체
│   └── 📁 service      # Retrofit Service 인터페이스
│
└── 📂 presentation         
    ├── 📁 home
    ├── 📁 main         # MainActivity, 네비게이션 정의
    ├── 📁 search
    └── 📁 stockcheck
