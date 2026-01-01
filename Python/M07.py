## main Function
## 4 Functions
## names --> get list of names and return it
## write --> take a list of names and write to a file the names on each separate line
## read --> read the file and then for each name, take input for job and return list --> name job
## print --> print table format index/num name job

##Function - Take names

## Function -- Write Names

## Function -- Read Names and Take Input for Job Put in 1 List or 2 List

## Print The Table Index Name Job


##Questions

##try excep

def get_names():
    num = int(input("Enter number of names you want to input: "))
    li = []
    for i in range(num):
        li.append(input("Enter a name: "))
    return li



def write_to_file(li_names):
    wi = open("name.txt","w")
    with open("name.txt","w") as wi:
        for name in li_names:
            wi.write(name+"\n")
        wi.close()
def read_from_file():
    re = open("name.txt","r")
    li_names_jobs = []
    for line in re.readlines():
        job = input("Give me a Job: ")
        ## line = line.split("//")[0]
        name_job=line.strip() + " "+job
        li_names_jobs.append(name_job)

    return li_names_jobs
def print_table(li_name_jobs):
    # RoleNum      Name      Job
    # 1            Sri       LA
    # 2            Logan     LA
    # 3            Sydney    LA
    #li = [Sri LA, Sydney LA, Logan LA]
    counter = 1
    print(f'%-15s %-15s %-15s'%("RoleNum", "Name", "Job"))
    for name_job in li_name_jobs:
        split_name_job=name_job.split(" ")
        #print(split_name_job)
        #name --> 0th
        ##job --> 1st
        #print("Hello","World") --> Hello World
        print(f'%-15d %-15s %-15s'% (counter,split_name_job[0], split_name_job[1]))
        counter+=1


def main():
    try:
        li_names=get_names()
        write_to_file(li_names)
        li_name_jobs=read_from_file()
    #print(li_name_jobs)
        print_table(li_name_jobs)
    except Exception as e:
        print("Error Message")
    finally:
       print("This is the end")

main()