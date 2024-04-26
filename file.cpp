#include<iostream>
#include<fstream>
#include<iomanip>
using namespace std;
void insert(){
    string rn,name,Class,div,add;
    ofstream f("Tejash.txt",ios::app);
     cout<<"Enter roll no"<<endl;
     cin>>rn;
     cout<<"Enter name"<<endl;
     cin>>name;
     cout<<"Enter class"<<endl;
     cin>>Class;
     cout<<"Enter division"<<endl;
     cin>>div;
     cout<<"Enter address"<<endl;
     cin>>add;
    f<<left <<setw(20)<< rn << setw(20)<<name << setw(20) <<Class <<setw(20)<<div <<setw(20)<<add << endl;
    
    f.close();
    cout<<"student add sucessfully "<<endl;

}
void Delete(){
    ifstream f("db.txt");
    string data ,rn;
    
      cout<<"Enter roll no to delete";
     cin>>rn;
     string fileData;
    while(getline(f,data)){
         if(data.find(rn)==string::npos){
            fileData+=data;
            fileData+="\n";

         }

    }
    f.close();
    ofstream f1("db.txt",ios::out);
    f1 <<fileData;
    f.close();
}
void search(){
    ifstream f("db.txt");
    string data ,rn;
    bool found=false;
      cout<<"Enter roll no to search"<<endl;
     cin>>rn;
    
    while(getline(f,data)){
        if(data.find(rn)!=string::npos) { //return non position if index not found >>npos
         cout<<"student info"<<endl;
         cout<<data<<endl;
         found=true;
         break;
        }
    }
    f.close();
    if(!found){
        cout<<"student not found"<<endl;
    }

}
void display(){
    ifstream f("db.txt");
    string data;
    cout<<"data is"<<endl;
    while(getline(f,data)){
    cout<<data<<endl;
    }
    f.close();
}

int main(){
    ofstream f("db.txt",ios::out);
     f<<left <<setw(20)<< "RollNo" << setw(20)<<"Name" << setw(20) <<"Class" <<setw(20)<<"division" <<setw(20)<<"adderess"<<endl;
     f.close();
    int ip;
    while (ip!=-1){
        cout<<"\n enter your choice\n1.insert student\n2.delete student\n3.search Student\n4.display data\n5.exit\n---->";
        cin>>ip;
        switch(ip){
        case 1:
        insert();
          break;
        
        case 2:
        Delete();
    
          break;

         case 3:
         search();
        
          break;


         case 4:
         display();
          break;

         case 5:
         return 0;
          break;

        default:
        cout<<"pleas enter ur choice";
        break;
     }
         



    }
}