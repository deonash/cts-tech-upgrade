import React, { Component } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Link, Route, Switch } from "react-router-dom";
import DashboardComponent from "./components/DashboardComponent";
import GetUserComponent from "./components/GetUserComponent";
import LoginComponent from "./components/LoginComponent";

class App extends Component {
  render() {
    return (
      <div>
        <nav className="navbar navbar-expand navbar-light bg-light">
          <a href="/" className="navbar-brand">
            <img src="http://localhost:3000/svclient.png" alt="SVClient App" />
          </a>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"loadUsers"} className="nav-link">
                Dashboard
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"getUsers"} className="nav-link">
                Reports
              </Link>
            </li>
          </div>
        </nav>
        <div style={{ height: 40 }}></div>
        <div>
          <Switch>
            <Route exact path="/" component={LoginComponent}></Route>
            <Route
              exact
              path="/loadUsers"
              component={DashboardComponent}
            ></Route>
            <Route exact path="/getUsers" component={GetUserComponent}></Route>
          </Switch>
        </div>
      </div>
    );
  }
}

export default App;
