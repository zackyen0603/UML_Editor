# UML_Editor

UML_Editor is a final project for the Object-Oriented Analysis and Design course at National Central University. 
This project is implemented in Java and follows an object-oriented design approach to create a UML diagram editor.

UML_Editor 是一款使用 Java 開發的 UML 圖編輯器，基於 物件導向分析與設計（OOAD） 原則，支援 類別圖、關聯線、選取與編輯 功能，並提供 直覺化的 GUI 操作。

## 專案介紹
本專案根據課程 UML 編輯器需求文件所實作，提供：
- 建立基本物件（Class、Use Case）
- 連結物件（Association、Generalization、Composition）
- 組成物件群組與解除物件群組功能（Group / UnGroup）
- 物件選取、拖曳與修改名稱功能


---

## 安裝與使用方法

1. 確保您的系統已安裝 Java 19 或更新版本
2. 下載本專案的最新發行版本
3. 打開 Terminal 或CMD ，並導航至專案目錄
4. 執行以下命令來啟動本專案：
   ```bash
   java -jar UML_Editor_Java_2023.jar
---

##  功能說明
### A. 建立 UML 物件
- 支援的 UML 物件
  - 類別（Class）
  - 用例（Use Case）
- 操作方式
  1. 點擊左側 工具列 上的 `Class` 或 `Use Case` 按鈕。
  2. 在右側 畫布（Canvas） 點擊，建立 UML 物件。
  3. 持續點擊可重複新增相同類型的物件。

---

### B. 連結 UML 物件
- 支援的 UML 連線
  - 關聯（Association）
  - 泛化（Generalization）
  - 組合（Composition）
- 操作方式
  1. 點擊 工具列 上的 `Association`、`Generalization` 或 `Composition` 按鈕。
  2. 在 第一個 UML 物件 按住滑鼠左鍵（Mouse Pressed）。
  3. 拖曳到 第二個 UML 物件，釋放滑鼠（Mouse Released）。
  4. UML 物件間將生成對應的連結線。

---

###  C. 選取與群組
- 單一物件選取
  1. 點擊 `Select` 按鈕 進入選取模式。
  2. 點擊 UML 物件，將其選取（會顯示四個連接點）。
  3. 再次點擊其他區域可取消選取。

- 框選多個物件
  1. 按住滑鼠左鍵 拖曳形成矩形框。
  2. 框內的 UML 物件將被選取。

- 組成群組與解除群組
  - 組成群組：選取多個 UML 物件後，選擇 `Group` 功能。
  - 解除群組：選取一個已群組的物件後，選擇 `UnGroup` 功能。

---

###  D. 物件拖曳與改名
- 拖曳 UML 物件
  1. 進入 `Select` 模式。
  2. 按住物件並拖曳，可移動 UML 物件位置。
  3. 連接的關聯線會自動調整。

- 更改 UML 物件名稱
  1. 選取 UML 物件。
  2. 點擊 `Change Object Name` 選單。
  3. 輸入新名稱後確認，物件名稱即更新。

---

