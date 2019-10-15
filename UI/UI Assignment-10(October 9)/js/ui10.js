var sampleTasklist = new taskList("My Tasks");
var newTask = new taskFunction("Medium urgency");
var completedTask = new taskFunction("Completed Task");
completedTask.status = 6;
sampleTasklist.addNewTask(newTask);
sampleTasklist.addNewTask(completedTask);

//Angular JS: MVC
var app = angular.module("app", []);
app.controller("TaskListController", ["$scope", function($scope) {
    $scope.tasklist = sampleTasklist;
    $scope.selectedTask = null;

    $scope.selectTask = function(task) {
      $scope.selectedTask = task;
    }
    $scope.addNewTask = function(name) {
      var newtask = new taskFunction(name);
      $scope.tasklist.addNewTask(newtask);
      $scope.selectedTask = newtask;
      $scope.newtaskname = null;
    }
    $scope.deleteTask = function(task) {
	$scope.tasklist.deleteTask(task);
    }
 $scope.saveTask = function(name) {
      $scope.selectedTask=null;
    }

    $scope.resetSelectedTask = function() {
      $scope.selectedTask = null;
    }
  }]);

function taskList(name) {
  this.name = name;
  this.tasks = [];
  this.addNewTask = function(task) {
  this.tasks.push(task);
 //     console.log("Index inn add "+this.tasks.indexOf(task));
  }
this.deleteTask = function(task) {
console.log("INA "+this.tasks.length);
console.log("task "+task);
var index = this.tasks.findIndex(obj => obj.title==task);
console.log(index);
      //console.log("Index "+this.tasks.indexOf(task));
console.log("Index "+JSON.stringify(this.tasks));
this.tasks.splice(index, 1);
  }
}

function taskFunction(name) {
  this.title = name;
  this.duedate = null;
  this.description = null;
  this.reminder = null;
  this.urgency = 2;
  this.status=4;
  this.completed = false;
}