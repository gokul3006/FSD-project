import './App.css';
import TransactionInput from './Pages/TransactionInput';
import { BrowserRouter as Router,Routes, Route } from 'react-router-dom';
import DashboardPage from './Pages/DashboardPage';
function App() {
 return( 
 <Router>
     <Routes>
        <Route path="/" element={<DashboardPage/>}/>
        <Route path="/input" element={<TransactionInput/>}/>
     </Routes>
    
</Router>
);
}

export default App;
