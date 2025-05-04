# 💡 GitHub 실습 가이드라인

이번 실습의 목표는 GitHub 협업 흐름을 이해하고 직접 Pull Request(PR)을 생성해보는 것입니다. 아래 안내에 따라 실습을 진행해주세요.

---

## ✅ 실습 목표

- 본인 전용 브랜치 생성
- 주어진 `week06/` 폴더 안에 개인 폴더 및 실습 파일 업로드
- PR(Pull Request) 생성 후 코드 리뷰 요청

---

## 📁 디렉토리 구조

week06/ <br>
├── yourname1/ <br>
│ └── practice.java <br>
├── yourname2/ <br>
│ └── practice.java <br>
└── ...


---

## 📌 실습 순서

* IntelliJ로 실습 내용 먼저 알려드릴 예정입니다.
* 아래는 터미널에서 실습 가능한 명령어입니다.

1. **레포지토리 Fork 및 Clone**

   ```bash
   git clone https://github.com/원본계정/레포이름.git
   cd 레포이름

2. **브랜치 생성**: 브랜치 이름은 feature/본인이름 형식으로 만듭니다.

    ```bash
   git checkout -b feature/gyeore

3. **폴더 및 파일 추가**: week06/ 폴더 안에 본인 이름으로 된 폴더를 만들고, 실습 파일을 업로드합니다.

    ```bash
    mkdir -p week06/gyeore
    touch week06/gyeore/practice.java

4. **커밋 및 푸시**: 

    ```bash
    git add .
    git commit -m "feat: {이름} week06 실습내용 추가"
    git push origin feature/gyeore

5. **Pull Request 생성**

* GitHub 웹사이트에서 PR(Pull Request) 생성
* base: main, compare: feature/yourname 
* 제목: [Week06] yourname 실습 제출 
* 설명: pr template 따라서 작성