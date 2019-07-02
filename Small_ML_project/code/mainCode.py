#Imports
import pandas
from sklearn.preprocessing import StandardScaler
from pandas.plotting import scatter_matrix
import matplotlib.pyplot as plt
from sklearn import model_selection
from sklearn.preprocessing import LabelEncoder
from sklearn.metrics import classification_report
from sklearn.metrics import confusion_matrix
from sklearn.metrics import accuracy_score
from sklearn.linear_model import LogisticRegression
from sklearn.tree import DecisionTreeClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.discriminant_analysis import LinearDiscriminantAnalysis
from sklearn.naive_bayes import GaussianNB
from sklearn.svm import SVC


#Loading datasets, both training (first dataset) and dataset 2.
#Training dataset will be splitted into training/testing again because we need to fit the model
# and calculate the level of accuracy. This will be possible
#as this dataset has 1 more attribute (the class) that allows us to know the results of each
# record (whether the loan was adjudicated or not)
dataset = pandas.read_csv("train_ORIGINAL.csv", sep=",")
dataset2 = pandas.read_csv("test_ORIGINAL.csv", sep=",")

#Before substituting categorical values we get rid of NaN values.
dataset=dataset.dropna()
dataset2=dataset2.dropna()
#Also, we get rid of the first column (LOAN ID) since it is useless regarding our analysis
dataset=dataset.drop(dataset.columns[0], axis='columns')
dataset2=dataset2.drop(dataset2.columns[0], axis='columns')
#Here, we perform an analysis related to the data that we already have.
print("Dataset 1 shape ",dataset.shape)
print("Dataset 2 shape ",dataset2.shape)
print(dataset.head(20))
print(dataset.describe())

print(dataset.groupby('Loan_Status').size(),"\n")
print(dataset.groupby('Gender').size(),"\n")
print(dataset.groupby('Married').size(),"\n")
print(dataset.groupby('Dependents').size(),"\n")
print(dataset.groupby('Education').size(),"\n")
print(dataset.groupby('Self_Employed').size(),"\n")
print(dataset.groupby('Property_Area').size(),"\n")

dataset.plot(kind='box', subplots=False, layout=(2,2), sharex=False, sharey=False)
plt.show()
dataset.hist()
plt.show()
scatter_matrix(dataset, range_padding= 0.3, figsize = (8,8)) # figsize in inches
plt.show()

#Substitution of the categorical data and scaling process in either training and testing datasets
#Training dataset
array = dataset.values
X_train = array[:,0:11]
Y_train = array[:,11]
for i in range(11):
    if(isinstance(X_train[:,i][2], str) ):
        encoder = LabelEncoder()
        encoder.fit(X_train[:,i])
        X_train[:,i]=encoder.fit_transform(X_train[:,1])
sc_X = StandardScaler()
X_train = sc_X.fit_transform(X_train)

#dataset 2
array2 = dataset2.values
X_test2 = array2[:,0:11]
for i in range(11):
    if(isinstance(X_test2[:,i][2], str) ):
        encoder = LabelEncoder()
        encoder.fit(X_test2[:,i].astype(str))
        X_test2[:,i]=encoder.fit_transform(X_test2[:,1])
X_test2 = sc_X.fit_transform(X_test2)


#After some trials we choose a test size of the 25% of our data. It gave us good results during
# the trials.
test_size = 0.25
seed = 7
#Now, we split the training dataset into training_2 dataset and testing_1 dataset. These records
# will fit the model and measure the accuracy later on.
#Stratified Sampling takes into account the distribution of classes in the original dataset and attempts
# to produces split sets that have a more balanced class/label distribution for more accurate training results..
X_trainf, X_test, Y_trainf, Y_test = model_selection.train_test_split(X_train, Y_train,stratify=Y_train,
                                                                      test_size=test_size, random_state=seed)
scoring = 'accuracy'

#Model definitions
models = []
models.append(('LR', LogisticRegression(solver='liblinear', multi_class='ovr')))
models.append(('KNN', KNeighborsClassifier()))
models.append(('CART', DecisionTreeClassifier()))
models.append(('LinDisAnalysis',LinearDiscriminantAnalysis()))
models.append(('GaussianNB',GaussianNB()))
models.append(('SVC',SVC(gamma='auto')))

#Cross-validation procedure
summary = {}
results = []
names = []
for name, model in models:
    kfold = model_selection.KFold(n_splits=10, random_state=seed)
    cv_results = model_selection.cross_val_score(model, X_trainf, Y_trainf, cv=kfold,scoring='accuracy')
    results.append(cv_results)
    names.append(name)
    summary[name]=[cv_results.mean(), cv_results.std()]
    msg = "%s: %f (%f)" % (name, cv_results.mean(), cv_results.std())
    print(msg)

#Ploting results
fig = plt.figure()
fig.suptitle('Algorithm Comparison')
ax = fig.add_subplot(111)
plt.boxplot(results)
ax.set_xticklabels(names)
plt.show()

print("CART PREDICTIONS")
#Estimator definition
cart = DecisionTreeClassifier()
#Estimator fitting process
cart.fit(X_trainf, Y_trainf)
#Testing and result
predictions = cart.predict(X_test)
#Results analysis
print(accuracy_score(Y_test, predictions))
print(confusion_matrix(Y_test, predictions))
print(classification_report(Y_test, predictions))
summary['CART'].append(accuracy_score(Y_test, predictions))

print("LR PREDICTIONS")
lr = LogisticRegression(solver='liblinear', multi_class='ovr')
lr.fit(X_trainf, Y_trainf)
predictions = lr.predict(X_test)
print(accuracy_score(Y_test, predictions))
print(confusion_matrix(Y_test, predictions))
print(classification_report(Y_test, predictions))
summary['LR'].append(accuracy_score(Y_test, predictions))

print("KNN PREDICTIONS")
knn = KNeighborsClassifier()
knn.fit(X_trainf, Y_trainf)
predictions = knn.predict(X_test)
print(accuracy_score(Y_test, predictions))
print(confusion_matrix(Y_test, predictions))
print(classification_report(Y_test, predictions))
summary['KNN'].append(accuracy_score(Y_test, predictions))

print("LinDisAnalysis PREDICTIONS (LinearDiscriminantAnalysis)")
LinDisAnalysis=LinearDiscriminantAnalysis()
LinDisAnalysis.fit(X_trainf, Y_trainf)
predictions2 = LinDisAnalysis.predict(X_test)
print(accuracy_score(Y_test, predictions2))
print(confusion_matrix(Y_test, predictions2))
print(classification_report(Y_test, predictions2))
summary['LinDisAnalysis'].append(accuracy_score(Y_test, predictions))


print("GaussianNB PREDICTIONS")
GaussianNB=GaussianNB()
GaussianNB.fit(X_trainf, Y_trainf)
predictions3 = GaussianNB.predict(X_test)
print(accuracy_score(Y_test, predictions3))
print(confusion_matrix(Y_test, predictions3))
print(classification_report(Y_test, predictions3))
summary['GaussianNB'].append(accuracy_score(Y_test, predictions))

print("SVC PREDICTIONS")
SVC=SVC(gamma='auto')
SVC.fit(X_trainf, Y_trainf)
predictions4 = SVC.predict(X_test)
print(accuracy_score(Y_test, predictions4))
print(confusion_matrix(Y_test, predictions4))
print(classification_report(Y_test, predictions4))
summary['SVC'].append(accuracy_score(Y_test, predictions))


print("Summary ")
for i in summary:
    print("Model: ",i, " Accuracy(*): ",float(summary[i][0])," STD(*): ",float(summary[i][1]),
          " Tested accuracy: ",float(summary[i][2]))

x = [1,2,3,4,5,6]
plt.bar(x, height=[summary['LR'][0],summary['KNN'][0],summary['CART'][0],summary['LinDisAnalysis'][0],
                   summary['GaussianNB'][0],summary['SVC'][0]])
plt.xticks(x, list(summary.keys()))
plt.ylabel('Training accuracy')
plt.xlabel('Models')
plt.show()

plt.bar(x, height=[summary['LR'][1],summary['KNN'][1],summary['CART'][1],summary['LinDisAnalysis'][1],
                   summary['GaussianNB'][1],summary['SVC'][1]])
plt.xticks(x, list(summary.keys()))
plt.ylabel('STD of the training accuracy')
plt.xlabel('Models')
plt.show()

plt.bar(x, height=[summary['LR'][2],summary['KNN'][2],summary['CART'][2],summary['LinDisAnalysis'][2],
                   summary['GaussianNB'][2],summary['SVC'][2]])
plt.xticks(x, list(summary.keys()))
plt.ylabel('Tested accuracy')
plt.xlabel('Models')
plt.show()

#Dataset 2 predictions using all models we had analized
print("LIN PREDICTIONS")
predictions5 = LinDisAnalysis.predict(X_test2)
print(predictions5)

print("LR PREDICTIONS")
predictions6 = lr.predict(X_test2)
print(predictions6)

print("SVC PREDICTIONS")
predictions7 = SVC.predict(X_test2)
print(predictions7)

print("GaussianNB PREDICTIONS")
predictions8 = GaussianNB.predict(X_test2)
print(predictions8)

print("CART PREDICTIONS")
predictions9 = cart.predict(X_test2)
print(predictions9)

print("KNN PREDICTIONS")
predictions10 = cart.predict(X_test2)
print(predictions10)