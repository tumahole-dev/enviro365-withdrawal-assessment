const BASE_URL = "http://localhost:8080/api";

export async function getPortfolio(investorId) {
  const res = await fetch(`${BASE_URL}/investors/${investorId}/portfolio`);
  if (!res.ok) throw new Error("Failed to load portfolio");
  return res.json();
}

export async function createWithdrawal(productId, amount) {
  const res = await fetch(`${BASE_URL}/withdrawals`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ productId, amount }),
  });
  const data = await res.json();
  if (!res.ok) {
    throw new Error(data.message || "Withdrawal failed");
  }
  return data;
}

export async function getWithdrawalHistory() {
  const res = await fetch(`${BASE_URL}/withdrawals`);
  if (!res.ok) throw new Error("Failed to load withdrawal history");
  return res.json();
}

export function getCsvExportUrl(start, end) {
  return `${BASE_URL}/reports/withdrawals/csv?start=${start}&end=${end}`;
}