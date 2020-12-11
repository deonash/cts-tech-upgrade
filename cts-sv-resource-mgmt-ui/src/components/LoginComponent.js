import React, { Component } from "react";
//import SVClientDataService from "../services/svclient.data.service";
import "../App.css";

class LoginComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      message: "",
    };
  }

  render() {
    return (
      <div className="cotainer d-flex justify-content-center ">
        <div id="formContent">
          <div>
            <img
              src="http://localhost:3000/loginicon.png"
              id="icon"
              alt="SVClient Icon"
            />
          </div>
          <div align="center">
            <form>
              <input
                type="text"
                id="login"
                class="fadeIn second"
                name="login"
                placeholder="login"
              />
              <input
                type="text"
                id="password"
                class="fadeIn third"
                name="login"
                placeholder="password"
              />
              <input type="submit" class="fadeIn fourth" value="Log In" />
            </form>
          </div>
          <div id="formFooter">
            <a class="underlineHover" href="/">
              Forgot Password?
            </a>
          </div>
        </div>
      </div>
    );
  }
}
export default LoginComponent;
