JAVA='/mnt/nfs/work3/jfoley/bin/jdk1.8.0_31/bin/java' 
JAR='/mnt/nfs/work3/mhjang/AllQueryExperiment/project-final-0.1.0-SNAPSHOT.jar'
BASE_DIR='/mnt/nfs/work3/mhjang/AllQueryExperiment/clueweb_bprm/'
for x in $(ls ${BASE_DIR}); do
qsub -o rankedlist/${x}.rankedlist -e error.log -cwd -b y ${JAVA} -jar ${JAR} ${BASE_DIR}/${x}
done
