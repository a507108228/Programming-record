#include<iostream>
#include<string>
using namespace std;
/*案例描述：学校正在作毕设，共有3名老师，每位老师带5个学生，设计学生和老师的结构体：
在老师的结构体中，有老师姓名和一个存放5名学生的数组作为成员，
学生的成员有姓名/考试分数/创建数组存放3名老师，
通过函数给每个老师所带的学生赋值，最终打印出老师数据以及老师所带的学生数据*/

struct Student {
  string sname;
  int score;
};

struct Teacher {
  string tname;
  struct Student sArray[5];
};

// 给老师和学生赋值的函数
void allocateSpace(struct Teacher tArray[], int len) {
 
  string nameseed = "ABCDE";
  // 给老师开始赋值
  for (int i = 0; i < len; i++) {
    tArray[i].tname = "Teacher_";
    tArray[i].tname += nameseed[i];

    //通过循环给每个老师带的5名学生赋值
    for (int j = 0; j < 5;j++) {
    tArray[i].sArray[j].sname = "Student_";
    tArray[i].sArray[j].sname += nameseed[j];

    }
  }
}

//打印所有信息
void printInfo(struct Teacher tArray[], int len) {
  for (int i = 0; i < len;i++) {
  
      cout<<"老师姓名：" <<tArray[i].tname<< endl;

      for (int j = 0; j < 5; j++) {
      cout<<"学生姓名：" <<tArray[i].sArray[j].sname
        <<"考试分数" <<tArray[i].sArray[j].score<<endl;
      }
  }
}
  
int main() {
  //创建3名老师的数组
  struct Teacher tArray[3];

  //通过函数给3名老师的信息赋值，并给老师带的学生信息赋值
  int len = sizeof(tArray) / sizeof(tArray[0]);
  allocateSpace(tArray, len);

  //打印所有老师及所带学生的信息
  printInfo(tArray, len);

  system("pause");

  return 0;
}