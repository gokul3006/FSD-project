import React, { useState, useEffect } from "react";
import Chart from 'react-google-charts';
import { useNavigate } from "react-router-dom";
// Import CSS file for styling

const DashboardPage = () => {
    const [apiData, setApiData] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        // Fetch data from the API
        fetch('http://localhost:8083/user/data')
            .then(response => response.json())
            .then(data => {
                const sortedData = data.sort((a, b) => new Date(a.dateTime) - new Date(b.dateTime));
                setApiData(sortedData);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }, []);

    const handleOnClick = () => {
        navigate("/input");
    }

    return (
        <div className="dashboard-card">
            <div className="header">
                <h2>Transactions Dashboard</h2>
            </div>
            <div className="chart-container">
                {apiData.length > 0 ? (
                    <>
                        <Chart
                            width={'100%'}
                            height={'400px'}
                            chartType="LineChart"
                            loader={<div>Loading Chart...</div>}
                            data={[
                                ['Index', 'Z-Score', { role: 'style' }, { role: 'tooltip', type: 'string', p: { html: true } }],
                                ...apiData.map((item, index) => [
                                    index,
                                    item.zscore,
                                    item.isSuspicious ? 'point { size: 5; shape-type: circle; fill-color: red; }' : 'point { size: 5; shape-type: circle; fill-color: green; }',
                                    `<div>Time: ${item.dateTime}</div><div>Z-Score: ${item.zscore}</div><div>Amount: ${item.amount}</div>` // Custom tooltip with time, z-score, and amount
                                ])
                            ]}
                            options={{
                                title: 'Transactions Z-Score',
                                hAxis: {
                                    title: 'Index',
                                    ticks: apiData.map((_, index) => index),
                                },
                                vAxis: {
                                    title: 'Z-Score',
                                    format: '0',
                                    viewWindow: {
                                        min: -5,
                                        max: 5,
                                    },
                                    ticks: [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5], // Adding ticks for y-axis at every integer
                                },
                                legend: 'none',
                                pointSize: 5,
                                tooltip: { isHtml: true }, // Enable HTML tooltips
                                series: {},
                            }}
                            rootProps={{ 'data-testid': '1' }}
                        />
                        <Chart
                            width={'100%'}
                            height={'400px'}
                            chartType="LineChart"
                            loader={<div>Loading Chart...</div>}
                            data={[
                                ['Index', 'Amount', { role: 'style' }, { role: 'tooltip', type: 'string', p: { html: true } }],
                                ...apiData.map((item, index) => [
                                    index,
                                    item.amount,
                                    item.isSuspicious ? 'point { size: 5; shape-type: circle; fill-color: red; }' : 'point { size: 5; shape-type: circle; fill-color: green; }',
                                    `<div>Time: ${item.dateTime}</div><div>Amount: ${item.amount}</div><div>Z-Score: ${item.zscore}</div>` // Custom tooltip with time, amount, and z-score
                                ])
                            ]}
                            options={{
                                title: 'Transactions Amount',
                                hAxis: {
                                    title: 'Index',
                                    ticks: apiData.map((_, index) => index),
                                },
                                vAxis: {
                                    title: 'Amount',
                                    format: '0',
                                    viewWindow: {
                                        min: Math.min(...apiData.map(item => item.amount)) - 10,
                                        max: Math.max(...apiData.map(item => item.amount)) + 10,
                                    },
                                },
                                legend: 'none',
                                pointSize: 5,
                                tooltip: { isHtml: true }, // Enable HTML tooltips
                                series: {},
                            }}
                            rootProps={{ 'data-testid': '2' }}
                        />
                    </>
                ) : (
                    <div>Loading data...</div>
                )}
            </div>
            <div className="legend-container">
                <div className="legend-item">
                    <div className="legend-color red round"></div>
                    <span>Suspicious</span>
                </div>
                <div className="legend-item">
                    <div className="legend-color green round"></div>
                    <span>Not Suspicious</span>
                </div>
            </div>
            <div className="button-container">
                <button className="small-button" onClick={handleOnClick}>Add Transaction</button>
            </div>
        </div>
    );
}

export default DashboardPage;
