import React from 'react';
import ApiProgress from '../shared/ApiProgress';
import UserLoginPage from '../pages/UserLoginPage';
import UserSignupPage from '../pages/UserSignupPage';
import LanguageSelector from '../components/LanguageSelector';
import HomePage from '../pages/HomePage';
import UserPage from '../pages/UserPage';
import { HashRouter as Router, Route, Redirect, Switch } from 'react-router-dom';
import TopBar from '../components/TopBar';
import { connect } from 'react-redux';

// import {Authentication} from '../shared/AuthenticationContext';



class App extends React.Component{
// static contextType = Authentication;

  render(){
    
    const {isLoggedIn} = this.props;
    return (
      <div><Router>
        <TopBar />
        <Switch>
        <Route exact path="/" component={HomePage} />
         {!isLoggedIn && (
          <Route path="/login" component={UserLoginPage} />

         )}
        <Route path="/signup" component={UserSignupPage} />
        <Route path="/user/:username" component={UserPage} /> //dinamik page
        <Redirect to ="/" />    //match etmezse buraya at
        </Switch>
      </Router>
      <LanguageSelector />
      </div>
    );
  }
}

const mapStateToProps = (store) => {
  return {
      isLoggedIn: store.isLoggedIn,
  };

};

export default connect(mapStateToProps)(App);
