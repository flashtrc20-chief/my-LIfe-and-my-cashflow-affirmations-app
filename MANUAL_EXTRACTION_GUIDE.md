# Manual PDF Extraction Template

Since the PDFs have complex formatting, here's the fastest way:

## For Each Month (September through January):

1. Open the PDF
2. Go to **Day 1** in the PDF
3. Copy:
   - Day number (1-31)
   - Day name (Monday, Tuesday, etc.)
   - The main title (e.g., "I HAVE CAPTURED SEPTEMBER")
   - All the paragraphs of text

4. Paste into the JSON template below
5. Repeat for all days in that month

---

## JSON Template (Copy for each month):

```json
{
  "name": "September Affirmations",
  "description": "Daily affirmations for September",
  "releasedDate": 1693526400,
  "affirmations": [
    {
      "dayNumber": 1,
      "dayName": "Monday",
      "title": "I HAVE CAPTURED SEPTEMBER",
      "paragraphs": [
        "Paragraph 1 text here...",
        "Paragraph 2 text here..."
      ],
      "order": 1
    },
    {
      "dayNumber": 2,
      "dayName": "Tuesday",
      "title": "Title here",
      "paragraphs": [
        "Paragraph 1...",
        "Paragraph 2..."
      ],
      "order": 2
    }
  ]
}
```

---

## Quick Approach: Firebase Sync Later

**Alternatively**, we can:
1. **Skip manual conversion for now**
2. **Build and test the app** with sample data
3. **Upload content to Firebase** manually via Firebase Console (easier!)

Which would you prefer?
