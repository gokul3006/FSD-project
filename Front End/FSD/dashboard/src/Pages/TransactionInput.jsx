import React, { useState } from "react";
import axios from 'axios';


const TransactionInput = () => {
    const [amount, setAmount] = useState(0.0);
    const [dateTime, setDateTime] = useState('');
    const [showSuccess, setShowSuccess] = useState(false);
    const [responseMessage, setResponseMessage] = useState('');

    const handleOnClick = async (e) => {
        e.preventDefault();

        const data = {
            amount: amount,
            timestamp: dateTime
        };

        try {
            const response = await axios.post("http://localhost:8080/process-data", data);
            setShowSuccess(true);
            setResponseMessage(response.data);
            console.log(response);
        } catch (error) {
            setShowSuccess(true);
            setResponseMessage(error.message);
            console.error(error);
        }
    }

    return (
        <div className="form-container">
            <div className="form-group">
                <label>Amount</label>
                <input
                    type="number"
                    value={amount}
                    onChange={(e) => setAmount(parseFloat(e.target.value))}
                />
            </div>
            <div className="form-group">
                <label htmlFor="datetime">Select Date and Time:</label>
                <input
                    type="datetime-local"
                    id="datetime"
                    name="datetime"
                    value={dateTime}
                    onChange={(e) => setDateTime(e.target.value)}
                />
            </div>
            <div className="form-group">
                <button onClick={handleOnClick}>Submit</button>
            </div>
            {showSuccess && (
                <div className="success-popup">
                    <p>{responseMessage}</p>
                    <button onClick={() => setShowSuccess(false)}>Close</button>
                </div>
            )}
        </div>
    );
}

export default TransactionInput;
